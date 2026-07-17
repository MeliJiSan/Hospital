package com.mycompany.practicaHospital;

import java.sql.Timestamp;

public class Receta {
    private int idReceta;
    private Timestamp fechaEmision;
    private String indicacionesGenerales;
    private int idConsulta;

    public Receta() {
    }

    public Receta(Timestamp fechaEmision, String indicacionesGenerales, int idConsulta) {
        this.fechaEmision = fechaEmision;
        this.indicacionesGenerales = indicacionesGenerales;
        this.idConsulta = idConsulta;
    }

    public Receta(int idReceta, Timestamp fechaEmision, String indicacionesGenerales, int idConsulta) {
        this.idReceta = idReceta;
        this.fechaEmision = fechaEmision;
        this.indicacionesGenerales = indicacionesGenerales;
        this.idConsulta = idConsulta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getIndicacionesGenerales() {
        return indicacionesGenerales;
    }

    public void setIndicacionesGenerales(String indicacionesGenerales) {
        this.indicacionesGenerales = indicacionesGenerales;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
}
