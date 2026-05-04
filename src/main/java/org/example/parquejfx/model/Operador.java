package org.example.parquejfx.model;

public class Operador extends Empleado {

    private Zona zonaAsignada;

    public Operador(String nombre, String cedula, Zona zonaAsignada) {
        super(nombre, cedula);
        this.zonaAsignada = zonaAsignada;
    }

    public Zona getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(Zona zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }
}
