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
    // 0 = paciente aun no guardado en la base de datos
    private int idPaciente;

    private String nombre;
    private String apPat;
    private String apMat;
    private int edad;
    private String genero;
    private double peso;

    // Requeridos por la tabla "Hospital".pacientes (NOT NULL)
    private java.util.Date fechaNacimiento;
    private java.util.Date fechaHoraIngreso;
    private final java.util.Date creadoEn;

    private String alergias;
    private String observacionesSintomas;
    private String diagnostico;
    private boolean esSalida;

    private java.util.Date horaSalida;
    private String observacionesEgreso;

    public Paciente(String nombre, String apPat, String apMat, String genero, double peso,
                     java.util.Date fechaNacimiento, java.util.Date fechaHoraIngreso)  {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.creadoEn = new java.util.Date();
    }

    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public String getNombre() { return nombre; }
    public String getApPat() { return apPat; }
    public String getApMat() { return apMat; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getGenero() { return genero; }
    public double getPeso() { return peso; }

    public java.util.Date getFechaNacimiento() { return fechaNacimiento; }
    public java.util.Date getFechaHoraIngreso() { return fechaHoraIngreso; }
    public java.util.Date getCreadoEn() { return creadoEn; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getObservacionesSintomas() { return observacionesSintomas; }
    public void setObservacionesSintomas(String obs) { this.observacionesSintomas = obs; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public boolean isEsSalida() { return esSalida; }
    public void setEsSalida(boolean esSalida) { this.esSalida = esSalida; }
    
    public java.util.Date getHoraSalida() { return horaSalida; }
    public void setHoraSalida(java.util.Date horaSalida) { this.horaSalida = horaSalida; }

    public String getObservacionesEgreso() { return observacionesEgreso; }  
    public void setObservacionesEgreso(String observacionesEgreso) { this.observacionesEgreso = observacionesEgreso; }
  
    @Override
    public String toString() {
        return nombre + " " + apPat + " " + apMat;
    }
}