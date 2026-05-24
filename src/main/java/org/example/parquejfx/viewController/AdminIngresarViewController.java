package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminIngresarViewController {

    @FXML private TextField txtIdAdmin;
    @FXML private PasswordField txtContrasenaAdmin;
    @FXML private Label lblMensajeAdmin;
    @FXML private Button btnIngresar;
    @FXML private Button btnVolver;

    // Admin hardcodeado por ahora
    private final String ID_ADMIN = "admin123";
    private final String CONTRASENA_ADMIN = "admin123";

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

        if (id.equals(ID_ADMIN) && contrasena.equals(CONTRASENA_ADMIN)) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/example/parquejfx/admin-panel.fxml")
            );
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
        } else {
            mostrarError("ID o contraseña incorrectos.");
        }
    }

    @FXML
    private void volver() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/inicio.fxml")
        );
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    private void mostrarError(String mensaje) {
        lblMensajeAdmin.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeAdmin.setText(mensaje);
    }
}
