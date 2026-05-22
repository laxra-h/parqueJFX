package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.util.SceneManager;

import java.io.IOException;

public class VisitanteCrearViewController {

        @FXML private TextField txtNombre;
        @FXML private TextField txtDocumento;
        @FXML private PasswordField txtContrasena;
        @FXML private TextField txtEdad;
        @FXML private TextField txtEstatura;

        @FXML private Label lblMensaje;
        @FXML private Button btnContinuar;
        @FXML private Button btnVolver;

        private App app;

        public void setApp(App app) {
                this.app = app;
        }


        VisitanteController visitanteController;

        @FXML public void initialize() {

                visitanteController = new VisitanteController(app.parque);
        }

        @FXML
        private void continuar() throws Exception {

                boolean centinela = visitanteController.crearVisitante(txtNombre.getText(), txtDocumento.getText(), txtContrasena.getText(), txtEdad.getText(), txtEstatura.getText());
                        if (centinela) {
                                SceneManager.cambiarEscena(btnContinuar, "/org/example/parquejfx/visitante-panel.fxml");
                        }
                        SceneManager.cambiarEscena(btnContinuar, "/org/example/parquejfx/error-panel.fxml");
        }

        @FXML
        private void volver() throws Exception {
                SceneManager.cambiarEscena(btnVolver, "/org/example/parquejfx/visitante-bienvenida.fxml");
        }


}
