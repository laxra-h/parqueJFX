package org.example.parquejfx.controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField; // ← agregar este
import org.example.parquejfx.model.Familiar;
import org.example.parquejfx.model.General;
import org.example.parquejfx.model.Parque;
import org.example.parquejfx.model.Visitante;

public class VisitanteController {
    Parque parque;

    public VisitanteController(Parque parque) {
        this.parque = parque;
    }

    public boolean crearVisitante(String text, String txtDocumentoText, String txtContrasenaText, String txtEdadText, String txtEstaturaText) {
        return parque.crearVisitante(text, txtDocumentoText, txtContrasenaText, txtEdadText, txtEstaturaText);
    }

    public boolean verificarIngreso(TextField cedula, PasswordField contrasenia) {
        return parque.verificarIngresoVisitante(cedula.getText(), contrasenia.getText());
    }

    // VisitanteController.java
    public String getTipoTicket(Visitante visitante) {
        return (visitante.getTheTicket() instanceof General) ? "General" : (visitante.getTheTicket() instanceof Familiar)? "Familiar" : "Fast.Pass";
    }
}