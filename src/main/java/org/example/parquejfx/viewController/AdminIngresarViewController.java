package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.util.SceneManager;

public class AdminIngresarViewController implements IAppControlable {

    @FXML private TextField txtIdAdmin;
    @FXML private PasswordField txtContrasenaAdmin;
    @FXML private Label lblMensajeAdmin;
    @FXML private Button btnIngresar;
    @FXML private Button btnVolver;

    private App app;
    private AdminController adminController;

    @Override
    public void setApp(App app) {
        this.app = app;
        this.adminController = new AdminController(app.parque);
    }

    @FXML
    public void initialize() { }

    @FXML
    private void ingresar() throws Exception {
        String id = txtIdAdmin.getText().trim();
        String contrasena = txtContrasenaAdmin.getText().trim();

        if (id.isEmpty() || contrasena.isEmpty()) {
            mostrarError("Completa todos los campos.");
            return;
        }

        if (adminController.ingresar(id, contrasena)) {
            FXMLLoader loader = SceneManager.cambiarEscena(btnIngresar,
                    "/org/example/parquejfx/admin-panel.fxml");
            AdminPanelViewController ctrl = loader.getController();
            ctrl.setApp(this.app);
            ctrl.setAdminController(adminController);
        } else {
            mostrarError("ID o contraseña incorrectos.");
        }
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnVolver,
                "/org/example/parquejfx/inicio.fxml");
        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    private void mostrarError(String mensaje) {
        lblMensajeAdmin.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeAdmin.setText(mensaje);
    }
}