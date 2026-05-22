package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.util.SceneManager;

import javax.swing.*;

public class InicioViewController {
    @FXML
    private Label lblNombreParque;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lblAforo;
    @FXML
    private Button btnVisitante;
    @FXML
    private Button btnOperador;
    @FXML
    private Button btnAdministrador;

    private App app;

    public void setApp(App app) {
        this.app = app;
        // Si necesitas mostrar datos del parque en labels, hazlo aquí
        lblNombreParque.setText(app.parque.getNombre());
        lblAforo.setText("Aforo: " + app.parque.getAforoMaximo());
    }

    @FXML
    private void irAVisitante() throws Exception {
       FXMLLoader loader = SceneManager.cambiarEscena(btnVisitante, "/org/example/parquejfx/visitante-bienvenida.fxml");
        VisitanteBienvenidaViewController ctrl =loader.getController();
        ctrl.setApp(this.App);
    }

    @FXML
    private void irAOperador() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnOperador,
                "/org/example/parquejfx/operador-ingresar.fxml");
        OperadorIngresarViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    @FXML
    private void irAAdministrador() {

    }

}
