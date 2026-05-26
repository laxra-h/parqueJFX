package org.example.parquejfx.model;

public class DetallesAtraccion {
    private Visitante thevisitante;
    private Atraccion theAtraccion;



    public DetallesAtraccion(Visitante thevisitante, Atraccion theAtraccion){

        this.thevisitante=thevisitante;
        this.theAtraccion=theAtraccion;
    }

    public boolean verificarAcceso() {
        if (theAtraccion.getEstaturaMinima() <= thevisitante.getEstatura()
                && theAtraccion.getEdadMinima() <= thevisitante.getEdad()) {

            thevisitante.agregarDetalle(this); // ← usa "this" en vez de crear uno nuevo
            theAtraccion.setContadorVisitantes(theAtraccion.getContadorVisitantes() + 1);

            // Si llega a 500, cierra la atracción
            if (theAtraccion.getContadorVisitantes() >= 500) {
                theAtraccion.cerrarAtraccionMantenimiento();
            }

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
