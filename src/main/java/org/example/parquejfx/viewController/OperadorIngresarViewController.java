package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.util.SceneManager;


public class OperadorIngresarViewController implements  IAppControlable {

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
            FXMLLoader loader = SceneManager.cambiarEscena(btnIngresar, "/org/example/parquejfx/operador-panel.fxml");
            OperadorPanelViewController ctrl = loader.getController();
            ctrl.setApp(this.app);
        } else {                                                      // ← else aquí
            FXMLLoader loader = SceneManager.cambiarEscena(btnIngresar,
                    "/org/example/parquejfx/error-panel.fxml");
            ErrorViewController ctrl = loader.getController();
            ctrl.setMensaje("Cédula o contraseña incorrecta");
            ctrl.setRutaAnterior("/org/example/parquejfx/operador-ingresar.fxml");
            ctrl.setApp(this.app);
        }
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnVolver,
                "/org/example/parquejfx/inicio.fxml");
        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }
}