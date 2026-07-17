/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import java.util.ArrayList;
import java.util.List;

/**
 * Capa de logica de negocio (Controlador) del patron MVC.
 *
 * Reglas de diseno seguidas en esta clase (tarea Persona 4):
 *  - Nunca recibe componentes graficos (Swing) como parametro: solo tipos
 *    primitivos, String o java.util.Date. La Vista se encarga de leer sus
 *    propios campos y de mostrar los mensajes; el Controlador solo procesa
 *    datos y valida reglas de negocio.
 *  - Las operaciones criticas (registrar consulta, registrar egreso) se
 *    referencian por indice/ID de la lista en memoria, nunca por nombre,
 *    porque dos pacientes pueden compartir nombre. La busqueda por nombre
 *    (buscarPorNombre / buscarTodosPorNombre) solo se usa para la funcion
 *    de "Buscar paciente" de la interfaz, no para actualizar datos.
 *  - Todo metodo publico que ejecuta una accion regresa boolean (exito o
 *    fracaso) o lanza una excepcion controlada (IllegalArgumentException)
 *    cuando el llamado viola el contrato del metodo (por ejemplo, pasar un
 *    indice fuera de rango o un objeto nulo). Ningun metodo falla en
 *    silencio: siempre hay un boolean, un valor null explicito, o una
 *    excepcion que la Vista pueda capturar y mostrar al usuario.
 *
 * @author angel
 */
public class Controlador {

    private final ArrayList<Paciente> listaPacientes;

    public Controlador() {
        this.listaPacientes = new ArrayList<>();
    }

    // ================= CARGA INICIAL =================

    // Trae todos los pacientes ya guardados en la BD y llena la lista en memoria.
    // Se usa al iniciar el programa para mostrar los registros existentes.
    public void cargarPacientesDesdeBD() {
        List<Paciente> pacientesBD = Modelo.obtenerPacientes();
        listaPacientes.clear();
        listaPacientes.addAll(pacientesBD);
    }

    // ================= ACCESO SEGURO POR INDICE / ID =================
    // Estos metodos existen para que la Vista nunca tenga que hacer
    // listaPacientes.get(indice) directamente (eso puede lanzar
    // IndexOutOfBoundsException si el indice ya no es valido, por ejemplo
    // tras eliminar un registro). Aqui se valida el rango y se regresa
    // null de forma explicita si no hay paciente en esa posicion.

    // Devuelve el paciente en esa posicion de la lista/combo, o null si el
    // indice no existe. Se usa, por ejemplo, al elegir un paciente en el
    // combo o en la tabla para cargar sus datos reales.
    public Paciente obtenerPacientePorIndice(int indice) {
        if (indice < 0 || indice >= listaPacientes.size()) {
            return null;
        }
        return listaPacientes.get(indice);
    }

    // Busca por id_paciente (clave real de la BD), mas seguro que buscar
    // por nombre cuando ya se conoce el ID (p. ej. tras un insert).
    public Paciente obtenerPacientePorId(int idPaciente) {
        for (Paciente p : listaPacientes) {
            if (p.getIdPaciente() == idPaciente) {
                return p;
            }
        }
        return null;
    }

    public int obtenerIndice(Paciente paciente) {
        if (paciente == null) {
            return -1;
        }
        return listaPacientes.indexOf(paciente);
    }

    // ================= PACIENTE =================

    public boolean crearPaciente(String nombre, String apPat, String apMat, String genero, double peso,
                                  java.util.Date fechaNacimiento, java.util.Date fechaHoraIngreso) {
        if (!esSoloLetras(nombre) || !esSoloLetras(apPat) || !esSoloLetras(apMat)) {
            return false;
        }
        if (peso <= 0) {
            return false;
        }
        if (fechaNacimiento == null || fechaHoraIngreso == null) {
            return false;
        }

        Paciente nuevo = new Paciente(nombre, apPat, apMat, genero, peso, fechaNacimiento, fechaHoraIngreso);

        // Guarda en la tabla "Hospital".pacientes y recupera el id_paciente generado
        int idGenerado = Modelo.insertarPaciente(nuevo);
        if (idGenerado <= 0) {
            return false; // no se pudo guardar en la base de datos
        }
        nuevo.setIdPaciente(idGenerado);

        listaPacientes.add(nuevo);
        return true;
    }

    // ================= CONSULTA =================

    public boolean registrarConsulta(int indicePaciente, String alergias, String observaciones, String diagnostico) {
        Paciente p = obtenerPacientePorIndice(indicePaciente);
        if (p == null) {
            return false;
        }
        if (!esSoloLetras(alergias) || !esSoloLetras(observaciones) || !esSoloLetras(diagnostico)) {
            return false;
        }

        p.setAlergias(alergias);
        p.setObservacionesSintomas(observaciones);
        p.setDiagnostico(diagnostico);

        // El formulario no pide doctor, asi que se usa/crea uno por defecto
        // para poder cumplir con la FK NOT NULL de la tabla consultas.
        int idDoctor = Modelo.obtenerOCrearDoctorPorDefecto();
        if (idDoctor <= 0) {
            return false; // no hay forma de cumplir la FK id_doctor
        }

        Consulta consulta = new Consulta(
                alergias,
                observaciones,
                diagnostico,
                new java.sql.Timestamp(System.currentTimeMillis()),
                p.getIdPaciente(),
                idDoctor
        );
        Modelo.insertarConsulta(consulta);

        return true;
    }

    // ================= EGRESO =================

    public boolean registrarEgreso(int indicePaciente, java.util.Date horaSalida, String observaciones) {
        Paciente p = obtenerPacientePorIndice(indicePaciente);
        if (p == null) {
            return false;
        }
        if (horaSalida == null) {
            return false;
        }
        if (!esTextoValido(observaciones)) {
            return false;
        }

        p.setHoraSalida(horaSalida);
        p.setObservacionesEgreso(observaciones);
        p.setEsSalida(true);

        Egreso egreso = new Egreso(
                observaciones,
                new java.sql.Timestamp(System.currentTimeMillis()),
                p.getIdPaciente(),
                new java.sql.Time(horaSalida.getTime())
        );
        Modelo.insertarEgreso(egreso);

        return true;
    }

    // ================= BUSQUEDA (solo para la funcion "Buscar paciente") =================
    // Importante: estos metodos son unicamente para que el usuario localice
    // un registro por nombre desde la pantalla de busqueda. Ninguna otra
    // operacion del sistema (registrar consulta, registrar egreso, etc.)
    // depende de un nombre; todas usan indice/ID, que es unico.

    public Paciente buscarPorNombre(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return null;
        }

        String buscado = texto.trim().toLowerCase();

        for (Paciente p : listaPacientes) {
            String nombreCompleto = (p.getNombre() + " " + p.getApPat() + " " + p.getApMat()).toLowerCase();
            if (nombreCompleto.contains(buscado)) {
                return p;
            }
        }
        return null;
    }

    public List<Paciente> buscarTodosPorNombre(String texto) {
        List<Paciente> resultados = new ArrayList<>();

        if (texto == null || texto.trim().isEmpty()) {
            return resultados;
        }

        String buscado = texto.trim().toLowerCase();

        for (Paciente p : listaPacientes) {
            String nombreCompleto = (p.getNombre() + " " + p.getApPat() + " " + p.getApMat()).toLowerCase();
            if (nombreCompleto.contains(buscado)) {
                resultados.add(p);
            }
        }

        return resultados;
    }

    // ================= PRESENTACION DE DATOS =================

    public String obtenerInfoCompleta(Paciente p) {
        if (p == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(p.getNombre()).append(" ").append(p.getApPat()).append(" ").append(p.getApMat()).append("\n");
        sb.append("Edad: ").append(p.getEdad()).append("\n");
        sb.append("Genero: ").append(p.getGenero()).append("\n");
        sb.append("Peso: ").append(p.getPeso()).append("\n");
        sb.append("Alergias: ").append(p.getAlergias() != null ? p.getAlergias() : "—").append("\n");
        sb.append("Observaciones consulta: ").append(p.getObservacionesSintomas() != null ? p.getObservacionesSintomas() : "—").append("\n");
        sb.append("Diagnostico: ").append(p.getDiagnostico() != null ? p.getDiagnostico() : "—").append("\n");
        sb.append("Egresado: ").append(p.isEsSalida() ? "Sí" : "No").append("\n");

        if (p.isEsSalida() && p.getHoraSalida() != null) {
            java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
            sb.append("Hora de salida: ").append(formato.format(p.getHoraSalida())).append("\n");
            sb.append("Observaciones egreso: ").append(p.getObservacionesEgreso() != null ? p.getObservacionesEgreso() : "—").append("\n");
        }

        return sb.toString();
    }

    // ================= VALIDACIONES DE TEXTO =================

    public boolean esSoloLetras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        return texto.trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+");
    }

    public boolean esSoloNumeros(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        return texto.trim().matches("[0-9]+(\\.[0-9]+)?");
    }

    public boolean esTextoValido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        return texto.trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ0-9.,;:()\\-\\s]+");
    }

    // ================= GETTERS =================

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
}
