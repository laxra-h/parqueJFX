package org.example.parquejfx.controller;

import javafx.scene.control.TextField;
import org.example.parquejfx.model.Parque;

public class OperadorController {
    Parque parque;

    public OperadorController(Parque parque) {
        this.parque = parque;
    }


    public boolean ingresarOperador(TextField txtCedula, TextField txtContrasenia) {
      return parque.verificarIngresoOperador(txtCedula.getText(), txtContrasenia.getText());
    }


}
