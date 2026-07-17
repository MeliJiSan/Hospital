package com.mycompany.practicaHospital;

import java.sql.Timestamp;

public class Consulta {
    private int idConsulta;
    private String alergias;
    private String observacionesSintomas;
    private String diagnostico;
    private Timestamp fechaRegistro;
    private int idPaciente;
    private int idDoctor;

    public Consulta() {
    }

    public Consulta(String alergias, String observacionesSintomas, String diagnostico,
                     Timestamp fechaRegistro, int idPaciente, int idDoctor) {
        this.alergias = alergias;
        this.observacionesSintomas = observacionesSintomas;
        this.diagnostico = diagnostico;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
    }

    public Consulta(int idConsulta, String alergias, String observacionesSintomas, String diagnostico,
                     Timestamp fechaRegistro, int idPaciente, int idDoctor) {
        this.idConsulta = idConsulta;
        this.alergias = alergias;
        this.observacionesSintomas = observacionesSintomas;
        this.diagnostico = diagnostico;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getObservacionesSintomas() {
        return observacionesSintomas;
    }

    public void setObservacionesSintomas(String observacionesSintomas) {
        this.observacionesSintomas = observacionesSintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }
}
