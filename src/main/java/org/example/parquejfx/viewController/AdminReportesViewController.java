package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdminReportesViewController {

    @FXML private Label lblTotalVisitantes;
    @FXML private Label lblTotalTickets;
    @FXML private Label lblTotalAlertas;
    @FXML private Label lblTotalAtracciones;
    @FXML private Label lblTotalOperadores;
    @FXML private Label lblTotalIngresos;

    @FXML
    public void initialize() {

        // Datos de prueba
        lblTotalVisitantes.setText("47");
        lblTotalTickets.setText("32");
        lblTotalAlertas.setText("1");
        lblTotalAtracciones.setText("9");
        lblTotalOperadores.setText("3");
        lblTotalIngresos.setText("$850.000");
    }
}