/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaHospital;

/**
 *
 * @author Usuario
 */
public class Paciente {
    private String nombre;
    private String apPat;
    private String apMat;
    private int edad;
    private String genero;
    private String peso;
    
    private String alergias;
    private String observacionesSintomas;
    private String diagnostico;
    private boolean esSalida;
    
    private String horaSalida;
    private String observacionesEgreso;

    public Paciente(String nombre, String apPat, String apMat, int edad, String genero, String peso) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
    }

    public String getNombre() { return nombre; }
    public String getApPat() { return apPat; }
    public String getApMat() { return apMat; }
    public int getEdad() { return edad; }
    public String getGenero() { return genero; }
    public String getPeso() { return peso; }
    
    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getObservacionesSintomas() { return observacionesSintomas; }
    public void setObservacionesSintomas(String obs) { this.observacionesSintomas = obs; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public boolean isEsSalida() { return esSalida; }
    public void setEsSalida(boolean esSalida) { this.esSalida = esSalida; }
    
    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    public String getObservacionesEgreso() { return observacionesEgreso; }  
    public void setObservacionesEgreso(String observacionesEgreso) { this.observacionesEgreso = observacionesEgreso; }

    @Override
    public String toString() {
        return nombre + " " + apPat + " " + apMat;
    }
}