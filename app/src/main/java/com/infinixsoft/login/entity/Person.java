package com.infinixsoft.login.entity;

import java.util.Date;

public class Person {
    private String nombre;
    private String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Person() {

    }

    public Person(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
