package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.util.SceneManager;

import java.io.IOException;

public class OperadorPanelViewController implements IAppControlable{

    @FXML
    private Button btnControlAtracciones;

    @FXML
    private Button btnGenerarReporte;

    @FXML
    private Button btnNotificaciones;

    @FXML
    private Button btnRegistro;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSolicitarRevision;

    @FXML
    private Label lblEstaturaMin;

    @FXML
    private Label lblNombreAtraccion;

    @FXML
    private Label lblNombreParque;

    @FXML
    private Label lblOperador;

    @FXML
    private Label lblResgistroVisitante;

    @FXML
    private Label lblSistemaGestion;

    @FXML
    private Label lblTiempoEspera;

    @FXML
    private Label lblVisitantesAcumulados;

private App app;
OperadorController operadorController;

public void setApp(App app) {
    this.app = app;
    operadorController = new OperadorController(app.parque);
}


    @FXML
    void irControlAtracciones(ActionEvent event) {

    }

    @FXML
    void irNotificaciones(ActionEvent event) {

    }

    @FXML
    void irRegistroVisitantes(ActionEvent event) {

    }

    @FXML
    void irSolicitarRevision(ActionEvent event) {

    }

    @FXML
    void salir() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnSalir,
                "/org/example/parquejfx/operador-ingresar.fxml");
        OperadorIngresarViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

}
