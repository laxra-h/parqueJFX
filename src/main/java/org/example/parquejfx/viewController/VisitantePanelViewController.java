package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.General;
import org.example.parquejfx.model.Visitante;
import org.example.parquejfx.util.SceneManager;

public class VisitantePanelViewController implements IAppControlable {
    @FXML private Label lblNombreVisitante;
    @FXML private Label lblTipoTicket;
    @FXML private Label lblSaldo;
    @FXML private AnchorPane areaCentral;

    @FXML private Button btnTicket;
    @FXML private Button btnAtracciones;
    @FXML private Button btnMapa;
    @FXML private Button btnFavoritos;
    @FXML private Button btnNotificaciones;
    @FXML private Button btnPerfil;
    @FXML private Button btnSalir;

    @FXML private Label lblTituloSeccion;

   private App app;
   private Visitante visitanteActual;
   private VisitanteController visitanteController;

    public void setApp(App app) {
        this.app = app;
        visitanteController = new VisitanteController(app.parque);
    }

    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
        lblNombreVisitante.setText("Nombre: " + visitanteActual.getNombre());
        lblSaldo.setText("Saldo virtual: " + visitanteActual.getSaldoVirtual());
        lblTipoTicket.setText("Tipo de ticket: " + visitanteController.getTipoTicket(visitanteActual));
    }

    @FXML
    public void initialize() throws Exception {
        //cargarVista("visitante-ticket-view.fxml");
        //lblTituloSeccion.setText("Mis Tickets");
    }

    @FXML private void irATicket() throws Exception {
        cargarVista("visitante-ticket-view.fxml");
        lblTituloSeccion.setText("Mis Tickets");
    }

    @FXML private void irAAtracciones() throws Exception {
        cargarVista("visitante-atracciones-view.fxml");
        lblTituloSeccion.setText("Atracciones");
    }

    @FXML private void irAMapa() throws Exception {
        cargarVista("visitante-mapa-view.fxml");
        lblTituloSeccion.setText("Mapa del Parque");
    }

    @FXML private void irAFavoritos() throws Exception {
        cargarVista("visitante-favoritos-view.fxml");
        lblTituloSeccion.setText("Mis Favoritos");
    }

    @FXML private void irANotificaciones() throws Exception {
        cargarVista("visitante-notificaciones-view.fxml");
        lblTituloSeccion.setText("Notificaciones");
    }

    @FXML private void irAPerfil() throws Exception {
        cargarVista("visitante-perfil-view.fxml");
        lblTituloSeccion.setText("Mi Perfil");
    }

    @FXML private void salir() throws Exception {
        FXMLLoader loader = SceneManager.cambiarEscena(btnSalir,
                "/org/example/parquejfx/inicio.fxml");
        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this.app);
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
