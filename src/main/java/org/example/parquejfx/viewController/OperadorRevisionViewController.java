package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.model.Atraccion;
import org.example.parquejfx.model.EstadoAtraccion;

public class OperadorRevisionViewController {

    @FXML private ComboBox<String> cmbAtraccion;
    @FXML private Button btnAtracActiva;
    @FXML private Button btnAtracMantenimiento;
    @FXML private Button btnAtracCerrada;
    @FXML private Label lblMensajeAtrac;

    private OperadorController operadorController;

    @FXML
    public void initialize() {
        lblMensajeAtrac.setText("");
        // ComboBox vacío hasta recibir el controller
    }

    public void setOperadorController(OperadorController operadorController) {
        this.operadorController = operadorController;
        cargarAtracciones();
    }

    private void cargarAtracciones() {
        cmbAtraccion.getItems().clear();
        for (Atraccion a : operadorController.getAtraccionesZona()) {
            cmbAtraccion.getItems().add(a.getNombre());
        }
    }

    @FXML
    private void ActivarAtrac() {
        String nombre = cmbAtraccion.getValue();
        if (nombre == null) {
            lblMensajeAtrac.setText("⚠ Seleccione una atracción.");
            return;
        }
        boolean ok = operadorController.cambiarEstadoAtraccion(nombre, EstadoAtraccion.ACTIVA);
        lblMensajeAtrac.setText(ok
                ? "✅ Atracción activada correctamente."
                : "❌ No se pudo activar la atracción.");
    }

    @FXML
    private void MantenimientoAtrac() {
        String nombre = cmbAtraccion.getValue();
        if (nombre == null) {
            lblMensajeAtrac.setText("⚠ Seleccione una atracción.");
            return;
        }
        boolean ok = operadorController.cambiarEstadoAtraccion(nombre, EstadoAtraccion.EN_MANTENIMIENTO);
        lblMensajeAtrac.setText(ok
                ? "🔧 Atracción enviada a mantenimiento."
                : "❌ No se pudo cambiar el estado.");
    }

    @FXML
    private void CerrarAtrac() {
        String nombre = cmbAtraccion.getValue();
        if (nombre == null) {
            lblMensajeAtrac.setText("⚠ Seleccione una atracción.");
            return;
        }
        boolean ok = operadorController.cambiarEstadoAtraccion(nombre, EstadoAtraccion.CERRADA);
        lblMensajeAtrac.setText(ok
                ? "🔒 Atracción cerrada correctamente."
                : "❌ No se pudo cerrar la atracción.");
    }
}