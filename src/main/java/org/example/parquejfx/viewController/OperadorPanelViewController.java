package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.util.SceneManager;

public class OperadorPanelViewController implements IAppControlable {

    @FXML private Button btnRecarga;
    @FXML private Button btnRegistro;
    @FXML private Button btnSalir;
    @FXML private Button btnSolicitarRevision;
    @FXML private AnchorPane areaCentral; // ← asegúrate de que exista en tu FXML
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
    public void initialize() {}

    @Override
    public void setApp(App app) {
        this.app = app;
        this.operadorController = app.operadorController;
        cargarDatosSidebar();
    }
    private void refrescarContador() {
        lblVisitantesAcumulados.setText("Visitantes: " + operadorController.getVisitantesAcumulados());
    }
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


    @FXML
    private void irRegistroVisitantes(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-ingresoVisitante.fxml");
            OperadorIngresoVisitanteViewController ctrl = loader.getController();
            ctrl.setOperadorController(operadorController);
            lblResgistroVisitante.setText("Registro de visitantes");
            lblSistemaGestion.setText("Verificación de acceso a la atracción");
            refrescarContador(); // ← agrega esto
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irRecargaSaldo(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-recarga.fxml");
            OperadorRecargaViewController ctrl = loader.getController();
            ctrl.setOperadorController(operadorController);
            lblResgistroVisitante.setText("Recarga de saldo");
            lblSistemaGestion.setText("Recarga de saldo virtual para visitantes");
            refrescarContador(); // ← agrega esto
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irSolicitarRevision(ActionEvent event) {
        try {
            FXMLLoader loader = cargarVista("operador-revision-view.fxml");
            OperadorRevisionViewController ctrl = loader.getController();
            ctrl.setOperadorController(operadorController);
            lblResgistroVisitante.setText("Solicitar revisión técnica");
            lblSistemaGestion.setText("Gestión del estado de las atracciones");
            refrescarContador(); // ← agrega esto
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

    // ── Igual que en AdminPanel — carga y pone en el AnchorPane central ──
    private FXMLLoader cargarVista(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/" + fxml)
        );
        Parent vista = loader.load(); // ← aquí, antes decía AnchorPane vista
        AnchorPane.setTopAnchor(vista, 0.0);
        AnchorPane.setBottomAnchor(vista, 0.0);
        AnchorPane.setLeftAnchor(vista, 0.0);
        AnchorPane.setRightAnchor(vista, 0.0);
        areaCentral.getChildren().setAll(vista);
        return loader;
    }
}