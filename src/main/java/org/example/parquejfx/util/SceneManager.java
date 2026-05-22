package org.example.parquejfx.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneManager {

    public static FXMLLoader cambiarEscena(Button botonActual, String rutaFXML) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource(rutaFXML)
        );
        Stage stage = (Stage) botonActual.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        return loader; // ← retorna el loader
    }
}