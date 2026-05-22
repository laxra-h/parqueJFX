package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.parquejfx.App;
import org.example.parquejfx.util.SceneManager;

public class ErrorViewController {

    @FXML private Button btnOk;
    @FXML private Label lblCausaError;
    @FXML private Label lblError;

    private String rutaAnterior;
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void setMensaje(String mensaje) {
        lblCausaError.setText(mensaje);
    }

    public void setRutaAnterior(String ruta) {
        this.rutaAnterior = ruta;
    }

    @FXML
    void clickearOk() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnOk, rutaAnterior);
        IAppControlable ctrl = loader.getController();
        System.out.println("controlador obtenido: " + ctrl);
        ctrl.setApp(this.app);
    }
}