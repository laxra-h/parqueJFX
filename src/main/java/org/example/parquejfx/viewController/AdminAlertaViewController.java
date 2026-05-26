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

    // ← Ya NO inicialices aquí, espera a tener el adminController
    @FXML
    public void initialize() {
        // vacío intencionalmente
    }

    // ← Aquí está el cambio clave
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;

        // Sincroniza el estado visual con el estado real del modelo
        this.alertaActiva = adminController.isAlertaActiva();

        if (alertaActiva) {
            lblEstadoClima.setText("⚠ ALERTA ACTIVA");
            lblEstadoClima.setStyle("-fx-text-fill: #C0392B; -fx-font-weight: bold; -fx-font-size: 16px;");
            btnToggleAlerta.setText("✅ Desactivar Alerta Climática");
            btnToggleAlerta.setStyle("-fx-background-color: #1E8449; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 6px;");
            lblMensajeAlerta.setStyle("-fx-text-fill: #C0392B;");
            lblMensajeAlerta.setText("⚠ Alerta activa. Atracciones acuáticas y mecánicas cerradas.");
        } else {
            actualizarEstado();
            btnToggleAlerta.setText("⚠ Activar Alerta Climática");
            btnToggleAlerta.setStyle("");
            lblMensajeAlerta.setText("");
        }
    }

    @FXML
    private void toggleAlerta() {
        if (!alertaActiva) {
            alertaActiva = true;
            lblEstadoClima.setText("⚠ ALERTA ACTIVA");
            lblEstadoClima.setStyle("-fx-text-fill: #C0392B; -fx-font-weight: bold; -fx-font-size: 16px;");
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
        lblEstadoClima.setStyle("-fx-text-fill: #1E8449; -fx-font-weight: bold; -fx-font-size: 16px;");
    }
}