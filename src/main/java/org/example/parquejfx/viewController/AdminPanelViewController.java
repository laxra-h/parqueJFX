package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminPanelViewController {

    @FXML private Label lblTituloSeccion;
    @FXML private AnchorPane areaCentral;

    @FXML private Button btnEmpleados;
    @FXML private Button btnZonas;
    @FXML private Button btnAtracciones;
    @FXML private Button btnOperadores;
    @FXML private Button btnAlerta;
    @FXML private Button btnReportes;
    @FXML private Button btnSalir;

    @FXML
    public void initialize() throws Exception {
        cargarVista("admin-empleados-view.fxml");
        lblTituloSeccion.setText("Gestión de Empleados");
    }

    @FXML private void irAEmpleados() throws Exception {
        cargarVista("admin-empleados-view.fxml");
        lblTituloSeccion.setText("Gestión de Empleados");
    }

    @FXML private void irAZonas() throws Exception {
        cargarVista("admin-zonas-view.fxml");
        lblTituloSeccion.setText("Gestión de Zonas");
    }

    @FXML private void irAAtracciones() throws Exception {
        cargarVista("admin-atracciones-view.fxml");
        lblTituloSeccion.setText("Gestión de Atracciones");
    }

    @FXML private void irAOperadores() throws Exception {
        cargarVista("admin-operadores-view.fxml");
        lblTituloSeccion.setText("Asignar Operadores");
    }

    @FXML private void irAAlerta() throws Exception {
        cargarVista("admin-alerta-view.fxml");
        lblTituloSeccion.setText("Alerta Climática");
    }

    @FXML private void irAReportes() throws Exception {
        cargarVista("admin-reportes-view.fxml");
        lblTituloSeccion.setText("Reportes del Parque");
    }

    @FXML private void salir() throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/inicio.fxml")
        );
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    private void cargarVista(String fxml) throws Exception {
        AnchorPane vista = FXMLLoader.load(
                getClass().getResource("/org/example/parquejfx/" + fxml)
        );
        AnchorPane.setTopAnchor(vista, 0.0);
        AnchorPane.setBottomAnchor(vista, 0.0);
        AnchorPane.setLeftAnchor(vista, 0.0);
        AnchorPane.setRightAnchor(vista, 0.0);
        areaCentral.getChildren().setAll(vista);
    }
}
