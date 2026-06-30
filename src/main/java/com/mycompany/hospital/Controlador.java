/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

/**
 *
 * @author melan
 */
import java.util.ArrayList;
import java.util.Date;

public class Controlador {
    private ArrayList<Paciente> listaPacientes;

    public Controlador() {
        listaPacientes = new ArrayList<>();
    }

    // Recibe solo datos primitivos, sin componentes gráficos
    public void guardarIngreso(String nombre, String apellidoP, String apellidoM,
                               String genero, Date fechaNacimiento, double peso) {
        //Date horaRegistro = new Date(); // La hora va aquí, en el controlador
        Paciente p = new Paciente(nombre, apellidoP, apellidoM, genero, fechaNacimiento, peso);
        listaPacientes.add(p);
    }

    public void guardarConsulta(String nombrePaciente,
                                String alergias,
                                String observaciones,
                                String diagnostico,
                                String tipoSalida) {
 
        Paciente p = buscarUltimoPorNombre(nombrePaciente);
        if (p != null) {
            p.setAlergias(alergias);
            p.setObservaciones(observaciones);
            p.setDiagnostico(diagnostico);
            p.setTipoSalida(tipoSalida);   // "Alta" o "Baja" viene del RadioButton
        }
    }
    
    public void registrarEgreso(String nombrePaciente) {
        Paciente p = buscarUltimoPorNombre(nombrePaciente);
        if (p != null) {
            p.setHoraSalida(new Date());   // hora actual al momento del egreso
        }
    }
    
    /*public void registrarSalida(int indice, String observaciones,
                                String alergias, String diagnostico, String tipoSalida) {
        Paciente p = listaPacientes.get(indice);
        p.setHoraSalida(new Date());
        p.setObservaciones(observaciones);
        p.setAlergias(alergias);
        p.setDiagnostico(diagnostico);
        // tipoSalida = "Alta" o "Baja" según el RadioButton seleccionado
    }*/

    public ArrayList<Paciente> buscarPorNombre(String nombre) {
        ArrayList<Paciente> resultados = new ArrayList<>();
        for (Paciente p : listaPacientes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public ArrayList<Paciente> getTodos() {
        return listaPacientes;
    }
    
    private Paciente buscarUltimoPorNombre(String nombre) {
        for (int i = listaPacientes.size() - 1; i >= 0; i--) {
            if (listaPacientes.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
                return listaPacientes.get(i);
            }
        }
        return null;
    }
}

