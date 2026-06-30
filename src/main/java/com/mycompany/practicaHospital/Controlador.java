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

    public boolean crearPaciente(String nombre, String apPat, String apMat, int edad, String genero, String peso) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        Paciente nuevo = new Paciente(nombre, apPat, apMat, edad, genero, peso);
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
        return true;
    }

    public boolean registrarEgreso(int indicePaciente, String horaSalida, String observaciones) {
        if (indicePaciente < 0 || indicePaciente >= listaPacientes.size()) {
            return false;
        }
        Paciente p = listaPacientes.get(indicePaciente);
        p.setHoraSalida(horaSalida);
        p.setObservacionesEgreso(observaciones);
        p.setEsSalida(true);
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
        sb.append("Hora de salida: ").append(p.getHoraSalida()).append("\n");
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
