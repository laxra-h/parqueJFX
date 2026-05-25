package org.example.parquejfx.model;

import java.time.LocalDate;

public abstract class Ticket {
    protected String codigo;
    protected LocalDate fechaCompra;
    protected double precio;
    protected Visitante theVisitante;


    public Ticket(String codigo, LocalDate fechaCompra, double PRECIO) {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.precio = PRECIO;
    }

    public abstract boolean verificarPrioridad();

    @Override
    public String toString(){
        return "";
    }




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


    public void setPrecio(double PRECIO) {
        this.precio = PRECIO;
    }

    public Visitante getTheVisitante() {
        return theVisitante;
    }

    public void setTheVisitante(Visitante theVisitante) {
        this.theVisitante = theVisitante;
    }
}
