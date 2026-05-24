package org.example.parquejfx.model;

import java.time.LocalDate;

public class FastPass extends Ticket{

<<<<<<< HEAD
    public FastPass(String codigo, LocalDate fechaCompra, double precio) {
        super(codigo, fechaCompra, precio);
=======
    public static final double PRECIO = 80000;

    public FastPass(String codigo, LocalDate fechaCompra) {
        super(codigo, fechaCompra, PRECIO);
>>>>>>> dev_Daniel
    }

    @Override
    public boolean verificarPrioridad() {
        return true;
    }

<<<<<<< HEAD

=======
    @Override
    public String toString() {
        return "Fast pass";
    }
>>>>>>> dev_Daniel



}
