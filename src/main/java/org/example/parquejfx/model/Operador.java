package org.example.parquejfx.model;

public class Operador extends Empleado {

    private Zona zonaAsignada;
private Atraccion theAtraccion;

    public Operador(String nombre, String cedula, String contrasenia, Zona zonaAsignada) {
        super(nombre, cedula, contrasenia);
        this.zonaAsignada = zonaAsignada;
    }

    public Atraccion getTheAtraccion() {
        return theAtraccion;
    }

    public void setTheAtraccion(Atraccion theAtraccion) {
        this.theAtraccion = theAtraccion;
    }

    public Zona getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(Zona zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }
}
