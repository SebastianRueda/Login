package com.infinixsoft.login.entity;

public class Examen {

    private String nombre;
    private String fecha;
    private String estado;
    private String nombreMateria;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Examen(String nombre, String fecha, String estado, String nombreMateria) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
        this.nombreMateria = nombreMateria;
    }
}
