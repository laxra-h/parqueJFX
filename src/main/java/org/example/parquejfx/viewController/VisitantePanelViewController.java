package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class VisitantePanelViewController {
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

    @FXML
    public void initialize() throws Exception {
        cargarVista("visitante-ticket-view.fxml");
        lblTituloSeccion.setText("Mis Tickets");
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
