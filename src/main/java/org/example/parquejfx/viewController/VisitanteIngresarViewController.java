package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.util.SceneManager;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VisitanteIngresarViewController implements IAppControlable {

    @FXML private TextField txtDocumento;
    @FXML private PasswordField txtContrasenia;
    @FXML private Label lblMensaje;
    @FXML private Button btnIngresar;
    @FXML private Button btnVolver;

    private App app;
    VisitanteController visitanteController;

    public void setApp(App app) {
        this.app = app;
        visitanteController = new VisitanteController(app.parque);
    }

    @FXML
    public void initialize() {}

    @FXML
    private void ingresar() throws Exception {
        boolean centinela = visitanteController.verificarIngreso(txtDocumento, txtContrasenia);
        if (centinela) {
            FXMLLoader loader = SceneManager.cambiarEscena(btnIngresar,
                    "/org/example/parquejfx/visitante-panel.fxml");
            VisitantePanelViewController ctrl = loader.getController();
            ctrl.setApp(this.app);
            ctrl.setVisitanteActual(app.parque.getVisitanteActual(txtDocumento.getText()));
        } else {
            FXMLLoader loader = SceneManager.cambiarEscena(btnIngresar,
                    "/org/example/parquejfx/error-panel.fxml");
            ErrorViewController ctrl = loader.getController();
            ctrl.setMensaje("Cédula o contraseña incorrecta");
            ctrl.setRutaAnterior("/org/example/parquejfx/visitante-ingresar.fxml");
            ctrl.setApp(this.app);
        }
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnVolver,
                "/org/example/parquejfx/visitante-bienvenida.fxml");
        VisitanteBienvenidaViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }
}
