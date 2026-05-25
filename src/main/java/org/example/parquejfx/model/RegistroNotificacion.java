package org.example.parquejfx.model;

public class RegistroNotificacion {

    private Notificacion notificacion;
    private Visitante visitante;
    private boolean leido;

    public RegistroNotificacion( Visitante visitante, Notificacion notificacion) {
        this.visitante = visitante;
        this.notificacion = notificacion;
        this.leido = false;
    }


    public void marcarLeido(){

        this.leido = true;
    }

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public void setVisitante(Visitante visitante) {
        this.visitante = visitante;
    }
}
