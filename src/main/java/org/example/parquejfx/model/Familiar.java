package org.example.parquejfx.model;

import java.time.LocalDate;

public class Familiar extends Ticket{

    private int descuento;

    public static final double PRECIO = 50000;

    public Familiar(String codigo, LocalDate fechaCompra, int descuento) {
        super(codigo, fechaCompra, PRECIO);
        this.descuento = descuento;
    }


    public Familiar(String codigo, LocalDate fechaCompra, double precio, int descuento) {
        super(codigo, fechaCompra, precio);
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Familiar";
    }
    public boolean verificarPrioridad() {
        return false;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
