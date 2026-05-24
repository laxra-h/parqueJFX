package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.parquejfx.App;
import org.example.parquejfx.util.SceneManager;

import java.util.function.Consumer;

public class ErrorViewController {

    @FXML private Button btnOk;
    @FXML private Label lblCausaError;
    @FXML private Label lblError;

    private String rutaAnterior;
    private App app;

    private Consumer<IAppControlable> onOkCallback;

    public void setOnOkCallback(Consumer<IAppControlable> callback) {
        this.onOkCallback = callback;
    }

    @FXML
    void clickearOk() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnOk, rutaAnterior);
        IAppControlable ctrl = loader.getController();
        ctrl.setApp(this.app);
        if (onOkCallback != null) {
            onOkCallback.accept(ctrl); // ← le pasa el controlador al callback
        }
    }
    public void setApp(App app) {
        this.app = app;
    }

    public void setMensaje(String mensaje) {
        lblCausaError.setText(mensaje);
    }

    public void setRutaAnterior(String ruta) {
        this.rutaAnterior = ruta;
    }

}