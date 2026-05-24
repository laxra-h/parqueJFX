package org.example.parquejfx.model;

import java.time.LocalDate;

public class General extends Ticket{
public static final double PRECIO = 30000;
    public General(String codigo, LocalDate fechaCompra) {
        super(codigo, fechaCompra, PRECIO);
    }

    @Override
    public String toString() {
        return "General";
    }

    @Override
    public boolean verificarPrioridad() {
        return false;
    }
}
