package org.example.parquejfx.model;

public class Operador extends Empleado {

    private Zona zonaAsignada;

    public Operador(String nombre, String cedula, String contrasenia, Zona zonaAsignada) {
        super(nombre, cedula, contrasenia);
        this.zonaAsignada = zonaAsignada;
    }




    public Zona getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(Zona zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }
}
