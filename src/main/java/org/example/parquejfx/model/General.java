package org.example.parquejfx.model;

import java.time.LocalDate;

public class General extends Ticket{

    public General(String codigo, LocalDate fechaCompra, double precio) {
        super(codigo, fechaCompra, precio);
    }

    @Override
    public boolean verificarPrioridad() {
        return false;
    }
}
