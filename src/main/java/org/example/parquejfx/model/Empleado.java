package org.example.parquejfx.model;

public abstract class Empleado {
    protected String nombre;
    protected String cedula;
<<<<<<< HEAD
    private String contrasenia;
=======
    protected String contrasenia;
>>>>>>> dev_Daniel


    public Empleado(String nombre, String cedula, String contrasenia) {
        this.nombre = nombre;
        this.cedula = cedula;
<<<<<<< HEAD
        this.contrasenia=contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

=======
        this.contrasenia = contrasenia;
    }


>>>>>>> dev_Daniel
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
<<<<<<< HEAD
=======

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
>>>>>>> dev_Daniel
}
