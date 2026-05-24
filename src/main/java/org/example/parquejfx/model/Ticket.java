package org.example.parquejfx.model;

import java.time.LocalDate;

public abstract class Ticket {
    protected String codigo;
    protected LocalDate fechaCompra;
    protected double precio;
    protected Visitante theVisitante;

<<<<<<< HEAD
    public Ticket(String codigo, LocalDate fechaCompra, double precio) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
=======
    public Ticket(String codigo, LocalDate fechaCompra, double PRECIO) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.precio = PRECIO;
>>>>>>> dev_Daniel
    }

    public abstract boolean verificarPrioridad();

<<<<<<< HEAD

=======
    @Override
    public String toString(){
        return "";
    }
>>>>>>> dev_Daniel



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

<<<<<<< HEAD
    public void setPrecio(double precio) {
        this.precio = precio;
=======
    public void setPrecio(double PRECIO) {
        this.precio = PRECIO;
>>>>>>> dev_Daniel
    }

    public Visitante getTheVisitante() {
        return theVisitante;
    }

    public void setTheVisitante(Visitante theVisitante) {
        this.theVisitante = theVisitante;
    }
}
