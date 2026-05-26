package org.example.parquejfx.model;

import java.util.ArrayList;

public class Zona {
    private String nombre;
    private int capacidadMaxima;
    private ArrayList<Operador> listOperadores;
    private ArrayList<Atraccion> listAtracciones;

    public Zona(String nombre, int capacidadMaxima) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        listOperadores = new ArrayList<>();
        listAtracciones = new ArrayList<>();

    }
public boolean agregarAtraccion(Atraccion atraccion) {
        if (atraccion != null) {
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
