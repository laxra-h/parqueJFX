package org.example.parquejfx.model;

public class DetallesAtraccion {
    private Visitante thevisitante;
    private Atraccion theAtraccion;



    public DetallesAtraccion(Visitante thevisitante, Atraccion theAtraccion){

        this.thevisitante=thevisitante;
        this.theAtraccion=theAtraccion;
    }

    public boolean verificarAcceso(){
        if (theAtraccion.getEstaturaMinima() <= thevisitante.getEstatura() && theAtraccion.getEdadMinima() <= thevisitante.getEdad() ) {
            DetallesAtraccion detallesAtraccion = new DetallesAtraccion(thevisitante, theAtraccion);
            thevisitante.agregarDetalle(detallesAtraccion);
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
