package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.parquejfx.App;

import java.io.IOException;

public class VisitanteIngresarViewController {
    @FXML private TextField txtDocumento;
    @FXML private PasswordField txtContrasena;
    @FXML private Label lblMensaje;
    @FXML private Button btnIngresar;
    @FXML private Button btnVolver;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }


    @FXML public void initialize() {

    }

    @FXML private void ingresar() throws IOException{
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/visitante-panel.fxml")
        );
        Stage stage = (Stage) btnIngresar.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

    }
    @FXML private void volver() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/visitante-bienvenida.fxml")
        );
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

}
