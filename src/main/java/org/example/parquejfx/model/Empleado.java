package org.example.parquejfx.model;

public abstract class Empleado {
    protected String nombre;
    protected String cedula;
    private String contrasenia;


    public Empleado(String nombre, String cedula, String contrasenia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.contrasenia=contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
