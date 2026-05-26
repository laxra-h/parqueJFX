package org.example.parquejfx.model;

import java.time.LocalDate;
public class DetallesAtraccion {
    private Atraccion theAtraccion;
    private Visitante theVisitante;

    public DetallesAtraccion(Atraccion atraccion, Visitante visitante) {
        this.theAtraccion = atraccion;
        this.theVisitante = visitante;
    }

    public boolean verificarAcceso() {
        if (theAtraccion.getEstaturaMinima() <= theVisitante.getEstatura()
                && theAtraccion.getEdadMinima() <= theVisitante.getEdad()) {
            theAtraccion.setContadorVisitantes(theAtraccion.getContadorVisitantes() + 1); // ← corregido
            return true;
        }
        return false;
    }


    public Atraccion getTheAtraccion() {
        return theAtraccion;
    }

    public void setTheAtraccion(Atraccion theAtraccion) {
        this.theAtraccion = theAtraccion;
    }

    public Visitante getTheVisitante() {
        return theVisitante;
    }

    public void setTheVisitante(Visitante theVisitante) {
        this.theVisitante = theVisitante;
    }
}