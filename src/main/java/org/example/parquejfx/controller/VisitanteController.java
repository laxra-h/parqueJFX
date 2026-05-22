package org.example.parquejfx.controller;

import org.example.parquejfx.model.Administrador;
import org.example.parquejfx.model.Parque;

public class VisitanteController {
    Parque parque;

    public VisitanteController(Parque parque) {
        this.parque = parque;
    }

    public boolean crearVisitante(String text, String txtDocumentoText, String txtContrasenaText, String txtEdadText, String txtEstaturaText) {
        return parque.crearVisitante(text,  txtDocumentoText,  txtContrasenaText,  txtEdadText,  txtEstaturaText);
    }

}
