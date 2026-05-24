package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminZonasViewController {

    @FXML private TextField txtNombreZona;
    @FXML private TextField txtCapacidadZona;
    @FXML private Label lblMensajeZona;
    @FXML private Button btnGuardarZona;
    @FXML private Button btnLimpiarZona;
    @FXML private Button btnEliminarZona;

    @FXML private TableView<String[]> tablaZonas;
    @FXML private TableColumn<String[], String> colNombreZona;
    @FXML private TableColumn<String[], String> colCapacidadZona;
    @FXML private TableColumn<String[], String> colAtraccionesZona;

    private final ObservableList<String[]> zonas =
            FXCollections.observableArrayList(
                    new String[]{"Zona Aventura", "150", "3"},
                    new String[]{"Zona Splash",   "100", "3"},
                    new String[]{"Zona Fantasía", "80",  "3"}
            );

    private boolean modoCrear = true;

    @FXML
    public void initialize() {
        configurarColumnas();
        tablaZonas.setItems(zonas);
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colNombreZona.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[0]));
        colCapacidadZona.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[1]));
        colAtraccionesZona.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[2]));
    }

    private void configurarSeleccion() {
        tablaZonas.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        txtNombreZona.setText(seleccionado[0]);
                        txtCapacidadZona.setText(seleccionado[1]);
                        modoCrear = false;
                        lblMensajeZona.setText("");
                    }
                });
    }

    @FXML
    private void guardarZona() {
        String nombre = txtNombreZona.getText().trim();
        String capacidad = txtCapacidadZona.getText().trim();

        if (nombre.isEmpty() || capacidad.isEmpty()) {
            mostrarError("Completa todos los campos.");
            return;
        }

        try {
            int cap = Integer.parseInt(capacidad);
            if (cap <= 0) {
                mostrarError("La capacidad debe ser mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarError("La capacidad debe ser un número.");
            return;
        }

        if (modoCrear) {
            for (String[] z : zonas) {
                if (z[0].equalsIgnoreCase(nombre)) {
                    mostrarError("Ya existe una zona con ese nombre.");
                    return;
                }
            }
            zonas.add(new String[]{nombre, capacidad, "0"});
            mostrarExito("✓ Zona creada correctamente.");
        } else {
            String[] seleccionada = tablaZonas
                    .getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                seleccionada[0] = nombre;
                seleccionada[1] = capacidad;
                tablaZonas.refresh();
                mostrarExito("✓ Zona actualizada correctamente.");
            }
        }
        limpiarZona();
    }

    @FXML
    private void eliminarZona() {
        String[] seleccionada = tablaZonas
                .getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarError("Selecciona una zona de la tabla.");
            return;
        }
        zonas.remove(seleccionada);
        mostrarExito("✓ Zona eliminada correctamente.");
        limpiarZona();
    }

    @FXML
    private void limpiarZona() {
        txtNombreZona.clear();
        txtCapacidadZona.clear();
        tablaZonas.getSelectionModel().clearSelection();
        modoCrear = true;
        lblMensajeZona.setText("");
    }

    private void mostrarError(String mensaje) {
        lblMensajeZona.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeZona.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajeZona.setStyle("-fx-text-fill: #1E8449;");
        lblMensajeZona.setText(mensaje);
    }
}