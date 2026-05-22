package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VisitanteFavoritosViewController {

    @FXML private ComboBox<String> cmbAtracciones;
    @FXML private Button btnAgregar;
    @FXML private Label lblMensajeFavorito;

    @FXML private TableView<String[]> tablaFavoritos;
    @FXML private TableColumn<String[], String> colFavNombre;
    @FXML private TableColumn<String[], String> colFavZona;
    @FXML private TableColumn<String[], String> colFavEstado;
    @FXML private TableColumn<String[], String> colFavEspera;

    @FXML private Button btnEliminarFavorito;

    // Todas las atracciones disponibles para elegir
    private final String[][] todasAtracciones = {
            {"Montaña Rusa",         "Zona Aventura", "Activa",        "15 min"},
            {"Torre de Caída Libre", "Zona Aventura", "Activa",        "20 min"},
            {"Tren Minero",          "Zona Aventura", "Mantenimiento", "—"     },
            {"Río Salvaje",          "Zona Splash",   "Activa",        "10 min"},
            {"Tobogán Gigante",      "Zona Splash",   "Activa",        "8 min" },
            {"Splash Adventure",     "Zona Splash",   "Cerrada",       "—"     },
            {"Carrusel",             "Zona Fantasía", "Activa",        "5 min" },
            {"Mini Autos Chocones",  "Zona Fantasía", "Activa",        "7 min" },
            {"Tren Infantil",        "Zona Fantasía", "Activa",        "6 min" }
    };

    // Lista que guarda los favoritos del visitante
    private final ObservableList<String[]> favoritos =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        tablaFavoritos.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );
        configurarColumnas();
        cargarComboBox();
        tablaFavoritos.setItems(favoritos);
    }

    private void configurarColumnas() {
        colFavNombre.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[0]));

        colFavZona.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[1]));

        colFavEstado.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[2]));

        colFavEspera.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[3]));
    }

    private void cargarComboBox() {
        ObservableList<String> nombres = FXCollections.observableArrayList();
        for (String[] a : todasAtracciones) {
            nombres.add(a[0]);
        }
        cmbAtracciones.setItems(nombres);
    }

    @FXML
    private void agregarFavorito() {
        String seleccionada = cmbAtracciones.getValue();

        if (seleccionada == null) {
            mostrarError("Selecciona una atracción primero.");
            return;
        }

        // Verificar si ya está en favoritos para no repetir
        for (String[] f : favoritos) {
            if (f[0].equals(seleccionada)) {
                mostrarError("Esa atracción ya está en tus favoritos.");
                return;
            }
        }

        // Buscar los datos completos y agregarla
        for (String[] a : todasAtracciones) {
            if (a[0].equals(seleccionada)) {
                favoritos.add(a);
                mostrarExito("✓ " + seleccionada + " agregada a favoritos.");
                cmbAtracciones.setValue(null);
                return;
            }
        }
    }

    @FXML
    private void eliminarFavorito() {
        String[] seleccionada = tablaFavoritos
                .getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            mostrarError("Selecciona una atracción de la lista primero.");
            return;
        }

        favoritos.remove(seleccionada);
        mostrarExito("✓ " + seleccionada[0] + " eliminada de favoritos.");
    }

    private void mostrarError(String mensaje) {
        lblMensajeFavorito.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeFavorito.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajeFavorito.setStyle("-fx-text-fill: #1E8449;");
        lblMensajeFavorito.setText(mensaje);
    }
}