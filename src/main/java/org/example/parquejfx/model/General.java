package org.example.parquejfx.model;

import java.time.LocalDate;

public class General extends Ticket{
<<<<<<< HEAD

    public General(String codigo, LocalDate fechaCompra, double precio) {
        super(codigo, fechaCompra, precio);
=======
public static final double PRECIO = 30000;
    public General(String codigo, LocalDate fechaCompra) {
        super(codigo, fechaCompra, PRECIO);
    }

    @Override
    public String toString() {
        return "General";
>>>>>>> dev_Daniel
    }

    @Override
    public boolean verificarPrioridad() {
        return false;
    }
<<<<<<< HEAD

=======
>>>>>>> dev_Daniel
}
