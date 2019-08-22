package com.example.fernanda.agendabd.Modelos;

public class ModeloContacto {
    int id;
    String nombre;
    int numero;

    public ModeloContacto(int id, String nombre, int numero) {
        this.id = id;
        this.nombre = nombre;
        this.numero=numero;
    }

    public ModeloContacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero=numero;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int tel) {
        this.numero = numero;
    }
}
