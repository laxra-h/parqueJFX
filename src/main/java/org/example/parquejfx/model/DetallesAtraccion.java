package org.example.parquejfx.model;

import java.time.LocalDate;

public class DetallesAtraccion {
    private Visitante thevisitante;
    private Atraccion theAtraccion;
    private LocalDate fechaIngreso;

    public DetallesAtraccion(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean verificarAcceso(){
        if (theAtraccion.getEstaturaMinima() <= thevisitante.getEstatura() && theAtraccion.getEdadMinima() <= thevisitante.getEdad() ) {

        theAtraccion.cerrarAtraccionMantenimiento();
            return true;
        }
        return false;
        }







    public Visitante getThevisitante() {
        return thevisitante;
    }

    public void setThevisitante(Visitante thevisitante) {
        this.thevisitante = thevisitante;
    }

    public Atraccion getTheAtraccion() {
        return theAtraccion;
    }

    public void setTheAtraccion(Atraccion theAtraccion) {
        this.theAtraccion = theAtraccion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
