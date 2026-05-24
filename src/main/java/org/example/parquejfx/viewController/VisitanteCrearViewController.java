package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

        @FXML public void initialize() { }

        @FXML
        private void continuar() throws IOException {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/parquejfx/visitante-panel.fxml")
                );
                Stage stage = (Stage) btnContinuar.getScene().getWindow();
                stage.setScene(new Scene(loader.load()));

            // aquí daniel validará y creará el visitante
            // navega en el menu
        }

        @FXML
        private void volver() throws IOException {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/org/example/parquejfx/visitante-bienvenida.fxml")
                );
                Stage stage = (Stage) btnVolver.getScene().getWindow();
                stage.setScene(new Scene(loader.load()));
        }

}
