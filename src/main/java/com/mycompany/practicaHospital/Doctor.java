package com.mycompany.practicaHospital;

public class Doctor {
    private int idDoctor;
    private String nombreDoctor;
    private String numCedula;
    private String apellidoP;

    public Doctor() {
    }

    public Doctor(String nombreDoctor, String numCedula, String apellidoP) {
        this.nombreDoctor = nombreDoctor;
        this.numCedula = numCedula;
        this.apellidoP = apellidoP;
    }

    public Doctor(int idDoctor, String nombreDoctor, String numCedula, String apellidoP) {
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
        this.numCedula = numCedula;
        this.apellidoP = apellidoP;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
}
