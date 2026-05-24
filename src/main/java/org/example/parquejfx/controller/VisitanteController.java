package org.example.parquejfx.controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; // ← agregar este
import org.example.parquejfx.model.*;

import java.util.ArrayList;

public class VisitanteController {
    Parque parque;

    public VisitanteController(Parque parque) {
        this.parque = parque;
    }

    public boolean crearVisitante(String nombre, String cedula, String contrasenia, int edad, double estatura, float saldoVirtual) {
        return parque.createVisitante(nombre, cedula, contrasenia, edad, estatura, saldoVirtual);
    }

    public boolean verificarIngreso(TextField cedula, PasswordField contrasenia) {
        return parque.verificarIngresoVisitante(cedula.getText(), contrasenia.getText());
    }

    public String getTipoTicket(Visitante visitante) {
        return (visitante.getTheTicket() instanceof General) ? "General" : (visitante.getTheTicket() instanceof Familiar)? "Familiar" : "Fast.Pass";
    }

    public boolean comprarTicketGeneral (Visitante v){
        return v.comprarGeneral();
    }
    public boolean comprarTicketFamiliar (Visitante v){
        return v.comprarFamiliar(10);
    }
    public boolean comprarTicketFastPass (Visitante v){
        return v.comprarFastPass();
    }

    public boolean agregarFavorito(Visitante visitante, Atraccion atraccion) {
        return parque.agregarFavorito(visitante, atraccion);
    }

    public boolean eliminarFavorito(Visitante visitante, Atraccion atraccion) {
        return parque.eliminarFavorito(visitante, atraccion);
    }

    public ArrayList<Atraccion> getFavoritos(Visitante visitante) {
        return parque.getFavoritos(visitante);
    }

    public ArrayList<String> getNotificaciones(Parque parque) {

        ArrayList<String> mensajes = new ArrayList<>();
        for (Notificacion n : parque.getListNotificaciones()) {
            mensajes.add(n.generarNotificacion());
        }
        return mensajes;
    }
    public void actualizarPerfil(Visitante visitante, String nombre, int edad, double estatura) {
        parque.updateVisitante(visitante.getCedula(), nombre, edad, estatura);
    }
    public void actualizarContrasenia(Visitante v, String contrasenia){
        v.setContrasenia(contrasenia);
    }



    public void limpiarNotificaciones(Parque parque) {

        parque.getListNotificaciones().clear();

    }

}