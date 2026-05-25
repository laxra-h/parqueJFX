package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.Administrador;
import org.example.parquejfx.util.SceneManager;

public class AdminPanelViewController implements IAppControlable {

    @FXML private Label lblTituloSeccion;
    @FXML private AnchorPane areaCentral;

    @FXML private Button btnEmpleados;
    @FXML private Button btnZonas;
    @FXML private Button btnAtracciones;
    @FXML private Button btnOperadores;
    @FXML private Button btnAlerta;
    @FXML private Button btnReportes;
    @FXML private Button btnSalir;

    private App app;
    private AdminController adminController;
    private Administrador administrador;
    @Override
    public void setApp(App app) {
        this.app = app;
        this.adminController = new AdminController(app.parque);
    }
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    public void initialize() { }

    @FXML private void irAEmpleados() throws Exception {
        FXMLLoader loader = cargarVista("admin-empleados-view.fxml");
        AdminEmpleadosViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController); // ← faltaba esto
        lblTituloSeccion.setText("Gestión de empleados");
    }

    @FXML private void irAZonas() throws Exception {
        FXMLLoader loader = cargarVista("admin-zonas-view.fxml");
        AdminZonasViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController);
        lblTituloSeccion.setText("Gestión de Zonas");
    }

    @FXML private void irAAtracciones() throws Exception {
        FXMLLoader loader = cargarVista("admin-atracciones-view.fxml");
        AdminAtraccionesViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController);
        lblTituloSeccion.setText("Gestión de Atracciones");
    }

    @FXML private void irAOperadores() throws Exception {
        FXMLLoader loader = cargarVista("admin-operadores-view.fxml");
        AdminOperadoresViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController); // ← faltaba esto
        lblTituloSeccion.setText("Asignar operadores");

    }

    @FXML private void irAAlerta() throws Exception {
        FXMLLoader loader = cargarVista("admin-alerta-view.fxml");
        AdminAlertaViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController); // ← faltaba esto
        lblTituloSeccion.setText("Alerta climática");

    }

    @FXML private void irAReportes() throws Exception {
        FXMLLoader loader = cargarVista("admin-reportes-view.fxml");
        AdminReportesViewController ctrl = loader.getController();
        ctrl.setAdminController(adminController); // ← faltaba esto
        lblTituloSeccion.setText("Reportes del parque);
    }

    @FXML private void salir() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnSalir,
                "/org/example/parquejfx/inicio.fxml");
        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    private FXMLLoader cargarVista(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/" + fxml)
        );
        AnchorPane vista = loader.load();
        AnchorPane.setTopAnchor(vista, 0.0);
        AnchorPane.setBottomAnchor(vista, 0.0);
        AnchorPane.setLeftAnchor(vista, 0.0);
        AnchorPane.setRightAnchor(vista, 0.0);
        areaCentral.getChildren().setAll(vista);
        return loader;
    }
}