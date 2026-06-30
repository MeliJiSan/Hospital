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

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
}
