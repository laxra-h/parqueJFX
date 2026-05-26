package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.util.SceneManager;

public class OperadorPanelViewController implements IAppControlable {

    @FXML private Button btnGenerarReporte;
    @FXML private Button btnRegistro;
    @FXML private Button btnSalir;
    @FXML private Button btnSolicitarRevision;
    @FXML private Button btnControlAtracciones;
    @FXML private Button btnNotificaciones;
    @FXML private Label lblEstaturaMin;
    @FXML private Label lblNombreAtraccion;
    @FXML private Label lblNombreParque;
    @FXML private Label lblOperador;
    @FXML private Label lblResgistroVisitante;
    @FXML private Label lblSistemaGestion;
    @FXML private Label lblTiempoEspera;
    @FXML private Label lblVisitantesAcumulados;

    private App app;
    private OperadorController operadorController;

    @FXML
    public void initialize() {
        // vacío — los datos se cargan en setApp()
    }

    @Override
    public void setApp(App app) {
        this.app = app;
        this.operadorController = app.operadorController;
        cargarDatosSidebar();
    }

    // Método alternativo si necesitas pasar el controller directamente
    public void setOperadorController(OperadorController operadorController) {
        this.operadorController = operadorController;
        cargarDatosSidebar();
    }

    private void cargarDatosSidebar() {
        lblNombreParque.setText(operadorController.getParque().getNombre());
        lblOperador.setText("Operador: " + operadorController.getNombreOperador());
        lblNombreAtraccion.setText(operadorController.getNombreAtraccion());
        lblEstaturaMin.setText("Estatura mín: " + operadorController.getEstaturaMinima());
        lblTiempoEspera.setText("Tiempo de espera: " + operadorController.getTiempoEspera());
        lblVisitantesAcumulados.setText("Visitantes: " + operadorController.getVisitantesAcumulados());
    }

    // ── Navegación ────────────────────────────────────────────────

    @FXML
    private void irRegistroVisitantes(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-registro-view.fxml");
            // OperadorRegistroViewController ctrl = loader.getController();
            // ctrl.setOperadorController(operadorController);
            lblResgistroVisitante.setText("Registro de visitantes");
            lblSistemaGestion.setText("Sistema de gestión y verificación de visitantes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irControlAtracciones(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-control-atracciones-view.fxml");
            lblResgistroVisitante.setText("Control de atracciones");
            lblSistemaGestion.setText("Gestión del estado de la atracción asignada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irNotificaciones(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-notificaciones-view.fxml");
            lblResgistroVisitante.setText("Notificaciones");
            lblSistemaGestion.setText("Centro de notificaciones del sistema");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irGenerarReporte(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-reporte-view.fxml");
            lblResgistroVisitante.setText("Generar reporte");
            lblSistemaGestion.setText("Reporte de actividad de la atracción");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irSolicitarRevision(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-revision-view.fxml");
            lblResgistroVisitante.setText("Solicitar revisión técnica");
            lblSistemaGestion.setText("Envío de solicitudes de mantenimiento");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void salir() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnSalir,
                "/org/example/parquejfx/operador-ingresar.fxml");
        OperadorIngresarViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
    }

    // ── Utilidad ──────────────────────────────────────────────────

    private FXMLLoader cargarVista(String fxml) throws Exception {
        // Ajusta según cómo está implementado cargarVista en tu panel de admin
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/" + fxml));
        // Aquí iría la lógica para inyectar la vista en el AnchorPane central
        return loader;
    }
}