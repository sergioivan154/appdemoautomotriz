package com.example.sergio.applealtad.Entities;

public class Memoria {
    private static final Memoria ourInstance = new Memoria();
    public String videoManual = "";

    public static Memoria getInstance() {
        return ourInstance;
    }

    private Memoria() {
    }

}
