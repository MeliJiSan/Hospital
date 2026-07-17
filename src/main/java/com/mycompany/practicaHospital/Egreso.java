package com.mycompany.practicaHospital;

import java.sql.Time;
import java.sql.Timestamp;

public class Egreso {
    private int idEgreso;
    private String observacionesEgreso;
    private Timestamp fechaRegistro;
    private int idPaciente;
    private Time horaSalida;

    public Egreso() {
    }

    public Egreso(String observacionesEgreso, Timestamp fechaRegistro, int idPaciente, Time horaSalida) {
        this.observacionesEgreso = observacionesEgreso;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.horaSalida = horaSalida;
    }

    public Egreso(int idEgreso, String observacionesEgreso, Timestamp fechaRegistro, int idPaciente, Time horaSalida) {
        this.idEgreso = idEgreso;
        this.observacionesEgreso = observacionesEgreso;
        this.fechaRegistro = fechaRegistro;
        this.idPaciente = idPaciente;
        this.horaSalida = horaSalida;
    }

    public int getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        this.idEgreso = idEgreso;
    }

    public String getObservacionesEgreso() {
        return observacionesEgreso;
    }

    public void setObservacionesEgreso(String observacionesEgreso) {
        this.observacionesEgreso = observacionesEgreso;
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

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }
}
