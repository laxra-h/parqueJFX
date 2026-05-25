package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.controller.AdminController;

public class AdminAlertaViewController {

    @FXML private Label lblEstadoClima;
    @FXML private Button btnToggleAlerta;
    @FXML private Label lblMensajeAlerta;
    private AdminController adminController;
    private boolean alertaActiva = false;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    public void initialize() {
        actualizarEstado();
    }

    @FXML
    private void toggleAlerta() {
        if (!alertaActiva) {
            alertaActiva = true;
            lblEstadoClima.setText("⚠ ALERTA ACTIVA");
            lblEstadoClima.setStyle(
                    "-fx-text-fill: #C0392B; -fx-font-weight: bold; -fx-font-size: 16px;"
            );
            btnToggleAlerta.setText("✅ Desactivar Alerta Climática");
            btnToggleAlerta.setStyle("-fx-background-color: #1E8449; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6px;");
            lblMensajeAlerta.setStyle("-fx-text-fill: #C0392B;");
            lblMensajeAlerta.setText("⚠ Alerta activada. Atracciones acuáticas y mecánicas cerradas. Visitantes notificados.");
            adminController.activarAlerta();
        } else {
            alertaActiva = false;
            actualizarEstado();
            btnToggleAlerta.setText("⚠ Activar Alerta Climática");
            btnToggleAlerta.setStyle("");
            lblMensajeAlerta.setStyle("-fx-text-fill: #1E8449;");
            lblMensajeAlerta.setText("✓ Alerta desactivada. Atracciones reactivadas.");
            adminController.desactivarAlerta();
        }
    }

    private void actualizarEstado() {
        lblEstadoClima.setText("✅ Normal — Sin alertas activas");
        lblEstadoClima.setStyle(
                "-fx-text-fill: #1E8449; -fx-font-weight: bold; -fx-font-size: 16px;"
        );
    }
}