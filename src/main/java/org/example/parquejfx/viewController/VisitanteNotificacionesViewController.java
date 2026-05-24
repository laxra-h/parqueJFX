package org.example.parquejfx.viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.Visitante;

public class VisitanteNotificacionesViewController {

    @FXML private ListView<String> listaNotificaciones;
    @FXML private Label lblContadorNotif;


    private App app;
    private Visitante visitanteActual;
    private VisitanteController visitanteController;


    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
    }

    public void setApp(App app) {
        this.app = app;
        this.visitanteController = new VisitanteController(app.parque);
        cargarNotificaciones();
    }

    @FXML
    public void initialize() { }

    private void cargarNotificaciones() {
        listaNotificaciones.setItems(
                FXCollections.observableArrayList(
                        visitanteController.getNotificaciones(app.parque)
                )
        );
        actualizarContador();
    }

    @FXML
    private void limpiarNotificaciones() {
        // Solo limpia la vista del visitante, NO el modelo
        listaNotificaciones.getItems().clear();
        actualizarContador();
    }

    private void actualizarContador() {
        int total = listaNotificaciones.getItems().size();
        lblContadorNotif.setText(total + (total == 1
                ? " notificación"
                : " notificaciones"));
    }
}