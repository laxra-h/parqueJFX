package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.Zona;

public class AdminZonasViewController {

    @FXML private TextField txtNombreZona;
    @FXML private TextField txtCapacidadZona;
    @FXML private Label lblMensajeZona;
    @FXML private TableView<Zona> tablaZonas;
    @FXML private TableColumn<Zona, String> colNombreZona;
    @FXML private TableColumn<Zona, String> colCapacidadZona;
    @FXML private TableColumn<Zona, String> colAtraccionesZona;

    private AdminController adminController;
    private boolean modoCrear = true;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        cargarZonas();
    }

    @FXML
    public void initialize() {
        configurarColumnas();
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colNombreZona.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colCapacidadZona.setCellValueFactory(d ->
                new SimpleStringProperty(String.valueOf(d.getValue().getCapacidadMaxima())));
        colAtraccionesZona.setCellValueFactory(d ->
                new SimpleStringProperty(String.valueOf(d.getValue().getListOperadores().size())));
    }

    private void configurarSeleccion() {
        tablaZonas.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionada) -> {
                    if (seleccionada != null) {
                        txtNombreZona.setText(seleccionada.getNombre());
                        txtCapacidadZona.setText(String.valueOf(seleccionada.getCapacidadMaxima()));
                        modoCrear = false;
                        lblMensajeZona.setText("");
                    }
                });
    }

    private void cargarZonas() {
        tablaZonas.setItems(FXCollections.observableArrayList(adminController.getZonas()));
    }

    @FXML
    private void guardarZona() {
        String nombre = txtNombreZona.getText().trim();
        String capacidadStr = txtCapacidadZona.getText().trim();

        if (nombre.isEmpty() || capacidadStr.isEmpty()) {
            mostrarError("Completa todos los campos.");
            return;
        }

        try {
            int capacidad = Integer.parseInt(capacidadStr);
            if (capacidad <= 0) {
                mostrarError("La capacidad debe ser mayor a 0.");
                return;
            }

            if (modoCrear) {
                boolean agregada = adminController.agregarZona(nombre, capacidad);
                if (agregada) {
                    mostrarExito("✓ Zona creada correctamente.");
                } else {
                    mostrarError("Ya existe una zona con ese nombre.");
                    return;
                }
            } else {
                Zona seleccionada = tablaZonas.getSelectionModel().getSelectedItem();
                if (seleccionada != null) {
                    adminController.actualizarZona(seleccionada.getNombre(), capacidad);
                    mostrarExito("✓ Zona actualizada correctamente.");
                }
            }
            cargarZonas();
            limpiarZona();

        } catch (NumberFormatException e) {
            mostrarError("La capacidad debe ser un número.");
        }
    }

    @FXML
    private void eliminarZona() {
        Zona seleccionada = tablaZonas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarError("Selecciona una zona de la tabla.");
            return;
        }
        adminController.eliminarZona(seleccionada.getNombre());
        cargarZonas();
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