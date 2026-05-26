package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class OperadorRevisionViewController {

    @FXML
    private ComboBox<String> cmbAtraccion;

    @FXML
    private Button btnAtracActiva;

    @FXML
    private Button btnAtracMantenimiento;

    @FXML
    private Button btnAtracCerrada;

    @FXML
    private Label lblMensajeAtrac;

    @FXML
    public void initialize() {

        lblMensajeAtrac.setText("");

        // Datos de prueba
        cmbAtraccion.getItems().addAll(
                "Montaña Rusa",
                "Río Salvaje",
                "Torre Extrema",
                "Casa del Terror"
        );
    }

    @FXML
    private void ActivarAtrac() {

        String atraccion = cmbAtraccion.getValue();

        if (atraccion == null) {
            lblMensajeAtrac.setText("Seleccione una atracción.");
            return;
        }

        lblMensajeAtrac.setText("Atracción activada correctamente.");
        System.out.println("Atracción activada: " + atraccion);

        // Aquí va la lógica real:
        // atraccionSeleccionada.setEstado(Estado.ACTIVA);
    }

    @FXML
    private void MantenimientoAtrac() {

        String atraccion = cmbAtraccion.getValue();

        if (atraccion == null) {
            lblMensajeAtrac.setText("Seleccione una atracción.");
            return;
        }

        lblMensajeAtrac.setText("Atracción enviada a mantenimiento.");
        System.out.println("Atracción enviada a mantenimiento: " + atraccion);

        // Aquí va la lógica real:
        // atraccionSeleccionada.setEstado(Estado.MANTENIMIENTO);
    }

    @FXML
    private void CerrarAtrac() {

        String atraccion = cmbAtraccion.getValue();

        if (atraccion == null) {
            lblMensajeAtrac.setText("Seleccione una atracción.");
            return;
        }

        lblMensajeAtrac.setText("Atracción cerrada correctamente.");
        System.out.println("Atracción cerrada: " + atraccion);

        // Aquí va la lógica real:
        // atraccionSeleccionada.setEstado(Estado.CERRADA);
    }
}