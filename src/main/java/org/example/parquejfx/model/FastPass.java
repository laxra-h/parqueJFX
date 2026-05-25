package org.example.parquejfx.model;

import java.time.LocalDate;

public class FastPass extends Ticket{

    public static final double PRECIO = 80000;

    public FastPass(String codigo, LocalDate fechaCompra) {
        super(codigo, fechaCompra, PRECIO);
    }

    @Override
    public boolean verificarPrioridad() {
        return true;
    }

    @Override
    public String toString() {
        return "Fast pass";
    }



}
