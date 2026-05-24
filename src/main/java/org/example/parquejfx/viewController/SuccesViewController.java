package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.parquejfx.App;
import org.example.parquejfx.model.Visitante;
import org.example.parquejfx.util.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class SuccesViewController implements IAppControlable {

    @FXML
    private Button btnOk;

    private App app;
    private String rutaAnterior;



    @Override
    public void setApp(App app) {
        this.app = app;
    }

    public void setRutaAnterior(String ruta) {
        this.rutaAnterior = ruta;
    }

    @FXML
    void clickearOk() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnOk, rutaAnterior);
        IAppControlable ctrl = loader.getController();
        ctrl.setApp(this.app);
    }
}
