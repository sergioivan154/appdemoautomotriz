package com.example.sergio.applealtad.Entities;

/**
 * Created by Sergio Ivan Lopez on 08/03/2018.
 */

public class DirectorioPojo {
    String nombre;
    String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DirectorioPojo(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
