package org.example.parquejfx.model;

import java.time.LocalDate;

public class FastPass extends Ticket{

    public FastPass(String codigo, LocalDate fechaCompra, double precio) {
        super(codigo, fechaCompra, precio);
    }

    @Override
    public boolean verificarPrioridad() {
        return true;
    }





}
