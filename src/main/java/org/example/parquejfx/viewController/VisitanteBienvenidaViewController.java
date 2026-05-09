package org.example.parquejfx.viewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VisitanteBienvenidaViewController {
    @FXML private Button btnCrearPerfil;
    @FXML private Button btnYaTengoPerfil;
    @FXML private Button btnVolver;

    @FXML private void irACrear() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/visitante-crear.fxml")
        );
        Stage stage = (Stage) btnCrearPerfil.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
    @FXML private void irAIngresar() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/visitante-ingresar.fxml")
        );
        Stage stage = (Stage) btnYaTengoPerfil.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
    @FXML private void volver() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/inicio.fxml")
        );
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }
}
