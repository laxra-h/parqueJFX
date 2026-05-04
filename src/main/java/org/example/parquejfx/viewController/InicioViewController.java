package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class InicioViewController {
    @FXML private Label lblNombreParque;
    @FXML private Label lblDireccion;
    @FXML private Label lblAforo;
    @FXML private Button btnVisitante;
    @FXML private Button btnOperador;
    @FXML private Button btnAdministrador;

    @FXML
    public void initialize() {
        // aquí daniel conecta el parque después
    }

    @FXML
    private void irAVisitante() {
//        System.out.println("Click visitante");
    }

    @FXML
    private void irAOperador() { }

    @FXML
    private void irAAdministrador() { }
}
