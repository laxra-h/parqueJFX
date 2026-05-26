package org.example.parquejfx.model;

import java.util.ArrayList;

public class Zona {
    private String nombre;
    private int capacidadMaxima;
    private ArrayList<Atraccion> listAtracciones;
    private ArrayList<Operador> listOperadores;

    public Zona(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        listAtracciones = new ArrayList<>();
        listOperadores = new ArrayList<>();
    }


public boolean agregarAtraccion(Atraccion atraccion){

if(atraccion ==null){
        return false;
}

listAtracciones.add(atraccion);
return true;
}

    public ArrayList<Atraccion> getListAtracciones() {
        return listAtracciones;
    }

    public void setListAtracciones(ArrayList<Atraccion> listAtracciones) {
        this.listAtracciones = listAtracciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public ArrayList<Operador> getListOperadores() {
        return listOperadores;
    }

    public void setListOperadores(ArrayList<Operador> listOperadores) {
        this.listOperadores = listOperadores;
    }
}
