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
        private VisitanteController visitanteController;
        public void setApp(App app) {
                this.app = app;
                visitanteController =  new VisitanteController(app.parque);
        }


        @FXML public void initialize() {}

        @FXML
        private void continuar() throws Exception {

                boolean centinela = visitanteController.crearVisitante(txtNombre.getText(), txtDocumento.getText(), txtContrasena.getText(), Integer.parseInt(txtEdad.getText()), Double.parseDouble(txtEstatura.getText()), 0);
                        if (centinela) {
                               FXMLLoader loader = SceneManager.cambiarEscena(btnContinuar, "/org/example/parquejfx/visitante-panel.fxml");
                               VisitantePanelViewController ctrl = loader.getController();
                               ctrl.setApp(app);
                               ctrl.setVisitanteActual(app.parque.buscarVisitanteByCedula(txtDocumento.getText()));
                        }else {
                                FXMLLoader loader = SceneManager.cambiarEscena(btnContinuar, "/org/example/parquejfx/error-panel.fxml");
                                ErrorViewController ctrl = loader.getController();
                                ctrl.setMensaje("Error al crear visitante");
                                ctrl.setRutaAnterior("/org/example/parquejfx/visitante-crear.fxml");
                                ctrl.setApp(this.app);
                        }
        }

        @FXML
        private void volver() throws Exception {
                FXMLLoader loader = SceneManager.cambiarEscena(btnVolver, "/org/example/parquejfx/visitante-bienvenida.fxml");
                VisitanteBienvenidaViewController ctrl = loader.getController();
                ctrl.setApp(this.app);
        }

        }


