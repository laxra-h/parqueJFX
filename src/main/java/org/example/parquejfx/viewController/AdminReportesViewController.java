package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.parquejfx.controller.AdminController;

import java.text.NumberFormat;
import java.util.Locale;

public class AdminReportesViewController {

    @FXML private Label lblTotalVisitantes;
    @FXML private Label lblTotalTickets;
    @FXML private Label lblTotalAlertas;
    @FXML private Label lblTotalAtracciones;
    @FXML private Label lblTotalOperadores;
    @FXML private Label lblTotalIngresos;

    private AdminController adminController;

    // initialize() queda vacío — los datos se cargan cuando llega el controller
    @FXML
    public void initialize() {}

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        cargarDatos();
    }

    private void cargarDatos() {
        // Datos globales del parque (siempre actualizados)
        lblTotalAtracciones.setText(String.valueOf(adminController.getTotalAtracciones()));
        lblTotalOperadores.setText(String.valueOf(adminController.getTotalOperadores()));
        lblTotalVisitantes.setText(String.valueOf(adminController.getTotalVisitantes()));
        lblTotalAlertas.setText(adminController.getAlertasActivas() == 1
                ? "⚠ 1 alerta activa"
                : "✅ Sin alertas");

        // Datos diarios (solo HOY)
        lblTotalTickets.setText(String.valueOf(adminController.getTicketsHoy()));
        lblTotalIngresos.setText(formatearPesos(adminController.getIngresosHoy()));
    }

    private String formatearPesos(float valor) {
        NumberFormat fmt = NumberFormat.getNumberInstance(new Locale("es", "CO"));
        return "$" + fmt.format((long) valor);
    }
}