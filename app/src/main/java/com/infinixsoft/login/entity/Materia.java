package com.infinixsoft.login.entity;

public class Materia {

    private String nombre;
    private String estado;
    private String ofertadaCuatrimestre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOfertadaCuatrimestre() {
        return ofertadaCuatrimestre;
    }

    public void setOfertadaCuatrimestre(String ofertadaCuatrimestre) {
        this.ofertadaCuatrimestre = ofertadaCuatrimestre;
    }

    public Materia(String nombre, String estado, String ofertadaCuatrimestre) {
        this.nombre = nombre;
        this.estado = estado;
        this.ofertadaCuatrimestre = ofertadaCuatrimestre;
    }
}
