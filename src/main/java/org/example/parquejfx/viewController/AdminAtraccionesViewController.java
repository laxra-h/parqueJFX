package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminAtraccionesViewController {

    @FXML private TextField txtNombreAtr;
    @FXML private TextField txtCapacidadAtr;
    @FXML private TextField txtEstaturaAtr;
    @FXML private TextField txtEdadAtr;
    @FXML private TextField txtCostoAtr;
    @FXML private ComboBox<String> cmbTipoAtr;
    @FXML private ComboBox<String> cmbZonaAtr;
    @FXML private Label lblMensajeAtr;
    @FXML private Button btnGuardarAtr;
    @FXML private Button btnLimpiarAtr;
    @FXML private Button btnEliminarAtr;

    @FXML private TableView<String[]> tablaAtracciones;
    @FXML private TableColumn<String[], String> colNombreAtr;
    @FXML private TableColumn<String[], String> colZonaAtr;
    @FXML private TableColumn<String[], String> colTipoAtr;
    @FXML private TableColumn<String[], String> colEstadoAtr;
    @FXML private TableColumn<String[], String> colCapacidadAtr;
    @FXML private TableColumn<String[], String> colEstaturaAtr;

    private final ObservableList<String[]> atracciones =
            FXCollections.observableArrayList(
                    new String[]{"Montaña Rusa",         "Zona Aventura", "Mecánica", "Activa", "20",  "1.40"},
                    new String[]{"Torre de Caída Libre",  "Zona Aventura", "Mecánica", "Activa", "15",  "1.50"},
                    new String[]{"Tren Minero",           "Zona Aventura", "Mecánica", "Activa", "30",  "1.00"},
                    new String[]{"Río Salvaje",           "Zona Splash",   "Acuática", "Activa", "25",  "1.20"},
                    new String[]{"Tobogán Gigante",       "Zona Splash",   "Acuática", "Activa", "10",  "1.10"},
                    new String[]{"Splash Adventure",      "Zona Splash",   "Acuática", "Activa", "20",  "1.00"},
                    new String[]{"Carrusel",              "Zona Fantasía", "Infantil", "Activa", "20",  "0.80"},
                    new String[]{"Mini Autos Chocones",   "Zona Fantasía", "Infantil", "Activa", "16",  "0.90"},
                    new String[]{"Tren Infantil",         "Zona Fantasía", "Infantil", "Activa", "30",  "0.70"}
            );

    private boolean modoCrear = true;

    @FXML
    public void initialize() {
        cmbTipoAtr.setItems(FXCollections.observableArrayList(
                "Mecánica", "Acuática", "Infantil"
        ));
        cmbZonaAtr.setItems(FXCollections.observableArrayList(
                "Zona Aventura", "Zona Splash", "Zona Fantasía"
        ));
        configurarColumnas();
        tablaAtracciones.setItems(atracciones);
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colNombreAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[0]));
        colZonaAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[1]));
        colTipoAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[2]));
        colEstadoAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[3]));
        colCapacidadAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[4]));
        colEstaturaAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[5]));
    }

    private void configurarSeleccion() {
        tablaAtracciones.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        txtNombreAtr.setText(seleccionado[0]);
                        cmbZonaAtr.setValue(seleccionado[1]);
                        cmbTipoAtr.setValue(seleccionado[2]);
                        txtCapacidadAtr.setText(seleccionado[4]);
                        txtEstaturaAtr.setText(seleccionado[5]);
                        modoCrear = false;
                        lblMensajeAtr.setText("");
                    }
                });
    }

    @FXML
    private void guardarAtraccion() {
        String nombre = txtNombreAtr.getText().trim();
        String capacidad = txtCapacidadAtr.getText().trim();
        String estatura = txtEstaturaAtr.getText().trim();
        String edad = txtEdadAtr.getText().trim();
        String costo = txtCostoAtr.getText().trim();
        String tipo = cmbTipoAtr.getValue();
        String zona = cmbZonaAtr.getValue();

        if (nombre.isEmpty() || capacidad.isEmpty() ||
                estatura.isEmpty() || tipo == null || zona == null) {
            mostrarError("Completa los campos obligatorios.");
            return;
        }

        if (modoCrear) {
            for (String[] a : atracciones) {
                if (a[0].equalsIgnoreCase(nombre)) {
                    mostrarError("Ya existe una atracción con ese nombre.");
                    return;
                }
            }
            atracciones.add(new String[]{
                    nombre, zona, tipo, "Activa", capacidad, estatura
            });
            mostrarExito("✓ Atracción creada correctamente.");
        } else {
            String[] seleccionada = tablaAtracciones
                    .getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                seleccionada[0] = nombre;
                seleccionada[1] = zona;
                seleccionada[2] = tipo;
                seleccionada[4] = capacidad;
                seleccionada[5] = estatura;
                tablaAtracciones.refresh();
                mostrarExito("✓ Atracción actualizada correctamente.");
            }
        }
        limpiarAtr();
    }

    @FXML
    private void eliminarAtraccion() {
        String[] seleccionada = tablaAtracciones
                .getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarError("Selecciona una atracción de la tabla.");
            return;
        }
        atracciones.remove(seleccionada);
        mostrarExito("✓ Atracción eliminada correctamente.");
        limpiarAtr();
    }

    @FXML
    private void limpiarAtr() {
        txtNombreAtr.clear();
        txtCapacidadAtr.clear();
        txtEstaturaAtr.clear();
        txtEdadAtr.clear();
        txtCostoAtr.clear();
        cmbTipoAtr.setValue(null);
        cmbZonaAtr.setValue(null);
        tablaAtracciones.getSelectionModel().clearSelection();
        modoCrear = true;
        lblMensajeAtr.setText("");
    }

    private void mostrarError(String mensaje) {
        lblMensajeAtr.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeAtr.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajeAtr.setStyle("-fx-text-fill: #1E8449;");
        lblMensajeAtr.setText(mensaje);
    }
}