package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.util.SceneManager;

public class OperadorIngresarViewController {

    @FXML private Button btnIngresar;
    @FXML private Button btnVolver;
    @FXML private Label lblBienvenidoOperador;
    @FXML private Label lblContraseña;
    @FXML private Label lblNombreParque;
    @FXML private Label lblUsuario;
    @FXML private TextField txtCedula;
    @FXML private TextField txtContrasenia;

    private App app;
    private OperadorController operadorController;

    // initialize() vacío o sin lógica que dependa de app
    @FXML
    public void initialize() {
        // No usar app aquí
    }

    // Este método se llama DESPUÉS de cargar el FXML
    public void setApp(App app) {
        this.app = app;
        this.operadorController = new OperadorController(app.parque);
    }

    @FXML
    void ingresarOperador(ActionEvent event) throws Exception {
        boolean centinela = operadorController.ingresarOperador(txtCedula, txtContrasenia);
        if (centinela) {
            SceneManager.cambiarEscena(btnIngresar, "/org/example/parquejfx/operador-panel.fxml");
        } else {                                                      // ← else aquí
            SceneManager.cambiarEscena(btnIngresar, "/org/example/parquejfx/error-panel.fxml");
        }
    }

    @FXML
    private void volver() throws Exception {
        SceneManager.cambiarEscena(btnVolver, "/org/example/parquejfx/inicio.fxml");
    }
}