/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

import java.util.ArrayList;

public class Controlador {

    private final ArrayList<Paciente> listaPacientes;

    public Controlador() {
        this.listaPacientes = new ArrayList<>();
    }

    // Trae todos los pacientes ya guardados en la BD y llena la lista en memoria.
    // Se usa al iniciar el programa para mostrar los registros existentes.
    public void cargarPacientesDesdeBD() {
        java.util.List<Paciente> pacientesBD = Modelo.obtenerPacientes();
        listaPacientes.clear();
        listaPacientes.addAll(pacientesBD);
    }

    public boolean crearPaciente(String nombre, String apPat, String apMat, int edad, String genero, double peso,
                                  java.util.Date fechaNacimiento, java.util.Date fechaHoraIngreso) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        Paciente nuevo = new Paciente(nombre, apPat, apMat, edad, genero, peso, fechaNacimiento, fechaHoraIngreso);

        // Guarda en la tabla "Hospital".pacientes y recupera el id_paciente generado
        int idGenerado = Modelo.insertarPaciente(nuevo);
        if (idGenerado <= 0) {
            return false; // no se pudo guardar en la base de datos
        }
        nuevo.setIdPaciente(idGenerado);

        listaPacientes.add(nuevo);
        return true;
    }

    public boolean registrarConsulta(int indicePaciente, String alergias, String observaciones, String diagnostico) {
        if (indicePaciente < 0 || indicePaciente >= listaPacientes.size()) {
            return false;
        }
        Paciente p = listaPacientes.get(indicePaciente);
        p.setAlergias(alergias);
        p.setObservacionesSintomas(observaciones);
        p.setDiagnostico(diagnostico);

        // El formulario no pide doctor, asi que se usa/crea uno por defecto
        // para poder cumplir con la FK NOT NULL de la tabla consultas.
        int idDoctor = Modelo.obtenerOCrearDoctorPorDefecto();

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

    public boolean registrarEgreso(int indicePaciente, java.util.Date horaSalida, String observaciones) {
        if (indicePaciente < 0 || indicePaciente >= listaPacientes.size()) {
            return false;
        }
        Paciente p = listaPacientes.get(indicePaciente);
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
    
    public java.util.List<Paciente> buscarTodosPorNombre(String texto) {
    java.util.List<Paciente> resultados = new java.util.ArrayList<>();

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
    
    public int obtenerIndice(Paciente paciente) {
        return listaPacientes.indexOf(paciente);
    }
    
    public String obtenerInfoCompleta(Paciente p) {
    StringBuilder sb = new StringBuilder();
    sb.append("Nombre: ").append(p.getNombre()).append(" ").append(p.getApPat()).append(" ").append(p.getApMat()).append("\n");
    sb.append("Edad: ").append(p.getEdad()).append("\n");
    sb.append("Genero: ").append(p.getGenero()).append("\n");
    sb.append("Peso: ").append(p.getPeso()).append("\n");
    sb.append("Alergias: ").append(p.getAlergias() != null ? p.getAlergias() : "—").append("\n");
    sb.append("Observaciones consulta: ").append(p.getObservacionesSintomas() != null ? p.getObservacionesSintomas() : "—").append("\n");
    sb.append("Diagnostico: ").append(p.getDiagnostico() != null ? p.getDiagnostico() : "—").append("\n");
    sb.append("Egresado: ").append(p.isEsSalida() ? "Sí" : "No").append("\n");

    if (p.isEsSalida()) {
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
        sb.append("Hora de salida: ").append(formato.format(p.getHoraSalida())).append("\n");
        sb.append("Observaciones egreso: ").append(p.getObservacionesEgreso() != null ? p.getObservacionesEgreso() : "—").append("\n");
    }

    return sb.toString();
}
    
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

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
}
