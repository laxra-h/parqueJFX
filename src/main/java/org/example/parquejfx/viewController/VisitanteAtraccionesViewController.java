package org.example.parquejfx.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VisitanteAtraccionesViewController {

    @FXML private TableView<String[]> tablaAtracciones;
    @FXML private TableColumn<String[], String> colNombre;
    @FXML private TableColumn<String[], String> colZona;
    @FXML private TableColumn<String[], String> colTipo;
    @FXML private TableColumn<String[], String> colEstado;
    @FXML private TableColumn<String[], String> colEspera;
    @FXML private TableColumn<String[], String> colEstatura;

    @FXML private Button btnFiltroTodas;
    @FXML private Button btnFiltroAventura;
    @FXML private Button btnFiltroSplash;
    @FXML private Button btnFiltroFantasia;

    @FXML private Label lblMensajeAtraccion;

    // Datos de prueba hasta que tu compañero conecte el model
    private final String[][] atracciones = {
            {"Montaña Rusa",         "Zona Aventura", "Mecánica",  "Activa",        "15 min", "1.40m"},
            {"Torre de Caída Libre", "Zona Aventura", "Mecánica",  "Activa",        "20 min", "1.50m"},
            {"Tren Minero",          "Zona Aventura", "Mecánica",  "Mantenimiento", "—",      "1.00m"},
            {"Río Salvaje",          "Zona Splash",   "Acuática",  "Activa",        "10 min", "1.20m"},
            {"Tobogán Gigante",      "Zona Splash",   "Acuática",  "Activa",        "8 min",  "1.10m"},
            {"Splash Adventure",     "Zona Splash",   "Acuática",  "Cerrada",       "—",      "1.00m"},
            {"Carrusel",             "Zona Fantasía", "Infantil",  "Activa",        "5 min",  "0.80m"},
            {"Mini Autos Chocones",  "Zona Fantasía", "Infantil",  "Activa",        "7 min",  "0.90m"},
            {"Tren Infantil",        "Zona Fantasía", "Infantil",  "Activa",        "6 min",  "0.70m"}
    };

    @FXML
    public void initialize() {
        configurarColumnas();
        cargarTodas();
    }

    private void configurarColumnas() {
        colNombre.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[0]));
        colZona.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[1]));
        colTipo.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[2]));
        colEstado.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[3]));
        colEspera.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[4]));
        colEstatura.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue()[5]));
    }

    private void cargarTodas() {
        ObservableList<String[]> lista = FXCollections.observableArrayList(atracciones);
        tablaAtracciones.setItems(lista);
    }

    @FXML private void filtrarTodas() {
        cargarTodas();
        lblMensajeAtraccion.setText("");
    }

    @FXML private void filtrarAventura() {
        filtrarPorZona("Zona Aventura");
    }

    @FXML private void filtrarSplash() {
        filtrarPorZona("Zona Splash");
    }

    @FXML private void filtrarFantasia() {
        filtrarPorZona("Zona Fantasía");
    }

    private void filtrarPorZona(String zona) {
        ObservableList<String[]> filtrada = FXCollections.observableArrayList();
        for (String[] a : atracciones) {
            if (a[1].equals(zona)) filtrada.add(a);
        }
        tablaAtracciones.setItems(filtrada);
        lblMensajeAtraccion.setText("");
    }
}