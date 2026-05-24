package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.Visitante;
import org.example.parquejfx.util.SceneManager;

import java.time.LocalDate;

public class VisitanteTicketViewController {

    @FXML private Label lblTicketActivo;
    @FXML private Label lblFechaCompra;
    @FXML private Label lblSaldoTicket;
    @FXML private Label lblMensajeTicket;

    @FXML private Button btnComprarGeneral;
    @FXML private Button btnComprarFamiliar;
    @FXML private Button btnComprarFastPass;

    private App app;
    private Visitante visitanteActual;
    private VisitanteController visitanteController;

    public void setApp(App app) {
        this.app = app;
        lblSaldoTicket.setText(String.valueOf(visitanteActual.getSaldoVirtual()));
        visitanteController = new VisitanteController(app.parque);
    }

    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
    }

    @FXML
    public void initialize() {}

    @FXML
    private void comprarGeneral() throws Exception {
        boolean centinela = visitanteController.comprarTicketGeneral(visitanteActual);
        if (centinela) {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral, "/org/example/parquejfx/succes-panel.fxml");
            SuccesViewController ctrl = loader.getController();
            ctrl.setApp (app);
            lblFechaCompra.setText(LocalDate.now().toString());
            lblTicketActivo.setText(visitanteActual.getTheTicket().toString());
        }else {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral,
                    "/org/example/parquejfx/error-panel.fxml");
            ErrorViewController ctrl = loader.getController();
            ctrl.setMensaje("A ocurrido un error con la compra");
            ctrl.setRutaAnterior("/org/example/parquejfx/visitante-panel.fxml");
            ctrl.setApp(this.app);
            ctrl.setOnOkCallback(panelCtrl -> {
                VisitantePanelViewController panel = (VisitantePanelViewController) panelCtrl;
                panel.setVisitanteActual(visitanteActual);
                try {
                    panel.irATicket();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

    @FXML
    private void comprarFamiliar() throws Exception {
        boolean centinela = visitanteController.comprarTicketFamiliar(visitanteActual );
        if (centinela) {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral, "/org/example/parquejfx/succes-panel.fxml");
            SuccesViewController ctrl = loader.getController();
            ctrl.setApp (app);
        }else {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral,
                    "/org/example/parquejfx/error-panel.fxml");
            ErrorViewController ctrl = loader.getController();
            ctrl.setMensaje("A ocurrido un error con la compra");
            ctrl.setRutaAnterior("/org/example/parquejfx/visitante-ticket-view.fxml");
            ctrl.setApp(this.app);
        }

    }

    @FXML
    private void comprarFastPass() throws Exception {
        boolean centinela = visitanteController.comprarTicketFastPass(visitanteActual);
        if (centinela) {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral, "/vistas/success.fxml");
            SuccesViewController ctrl = loader.getController();
            ctrl.setApp(this.app);
            ctrl.setRutaAnterior("/org/example/parquejfx/visitante-ticket-view.fxm");
        }else {
            FXMLLoader loader = SceneManager.cambiarEscena(btnComprarGeneral,
                    "/org/example/parquejfx/error-panel.fxml");
            ErrorViewController ctrl = loader.getController();
            ctrl.setMensaje("A ocurrido un error con la compra");
            ctrl.setRutaAnterior("/org/example/parquejfx/visitante-ticket-view.fxml");
            ctrl.setApp(this.app);
        }

    }
}