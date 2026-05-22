package org.example.parquejfx.viewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.parquejfx.App;
import org.example.parquejfx.util.SceneManager;

import java.io.IOException;
public class VisitanteBienvenidaViewController {

    @FXML private Button btnCrearPerfil;
    @FXML private Button btnYaTengoPerfil;
    @FXML private Button btnVolver;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void irACrear() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnCrearPerfil,
                "/org/example/parquejfx/visitante-crear.fxml");
        VisitanteCrearViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    @FXML
    private void irAIngresar() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnYaTengoPerfil,
                "/org/example/parquejfx/visitante-ingresar.fxml");
        VisitanteIngresarViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnVolver,
                "/org/example/parquejfx/inicio.fxml");
        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }
}