package org.example.parquejfx.model;

public class DetallesAtraccion {
    private Visitante thevisitante;
    private Atraccion theAtraccion;

    public boolean verificarAcceso(){
        if (theAtraccion.getEstaturaMinima() <= thevisitante.getEstatura() && theAtraccion.getEdadMinima() <= thevisitante.getEdad() ) {
<<<<<<< HEAD
=======

>>>>>>> dev_Daniel
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
}
