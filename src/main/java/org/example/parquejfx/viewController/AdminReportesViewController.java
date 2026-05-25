package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.Parque;

public class AdminReportesViewController {

    @FXML private Label lblTotalVisitantes;
    @FXML private Label lblTotalTickets;
    @FXML private Label lblTotalAlertas;
    @FXML private Label lblTotalAtracciones;
    @FXML private Label lblTotalOperadores;
    @FXML private Label lblTotalIngresos;
    private AdminController adminController;
    private Parque parque;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        this.parque = adminController.getParque();
    }


    @FXML
    public void initialize() {
        lblTotalVisitantes.setText("1");
        lblTotalTickets.setText("32");
        lblTotalAlertas.setText("1");
        lblTotalAtracciones.setText("9");
        lblTotalOperadores.setText("3");
        lblTotalIngresos.setText("$850.000");
    }

}