package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.*;

public class AdminAtraccionesViewController {

    @FXML private TextField txtCodigoAtr;
    @FXML private TextField txtNombreAtr;
    @FXML private TextField txtCapacidadAtr;
    @FXML private TextField txtEstaturaAtr;
    @FXML private TextField txtEdadAtr;
    @FXML private TextField txtCostoAtr;
    @FXML private ComboBox<TipoAtraccion> cmbTipoAtr;
    @FXML private ComboBox<Zona> cmbZonaAtr;
    @FXML private Label lblMensajeAtr;

    @FXML private TableView<Atraccion> tablaAtracciones;
    @FXML private TableColumn<Atraccion, String> colNombreAtr;
    @FXML private TableColumn<Atraccion, String> colZonaAtr;
    @FXML private TableColumn<Atraccion, String> colTipoAtr;
    @FXML private TableColumn<Atraccion, String> colEstadoAtr;
    @FXML private TableColumn<Atraccion, String> colCapacidadAtr;
    @FXML private TableColumn<Atraccion, String> colEstaturaAtr;

    private AdminController adminController;
    private boolean modoCrear = true;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        cargarDatos();
    }

    @FXML
    public void initialize() {
        cmbTipoAtr.setItems(FXCollections.observableArrayList(TipoAtraccion.values()));
        configurarColumnas();
        configurarSeleccion();
        configurarComboZona();
    }

    private void configurarComboZona() {
        cmbZonaAtr.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Zona z, boolean empty) {
                super.updateItem(z, empty);
                setText(empty || z == null ? null : z.getNombre());
            }
        });
        cmbZonaAtr.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Zona z, boolean empty) {
                super.updateItem(z, empty);
                setText(empty || z == null ? "Selecciona una zona" : z.getNombre());
            }
        });
    }

    private void configurarColumnas() {
        colNombreAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colZonaAtr.setCellValueFactory(d -> {
            Zona zona = d.getValue().getZona();
            return new SimpleStringProperty(zona != null ? zona.getNombre() : "Sin zona");
        });
        colTipoAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTipo().toString()));
        colEstadoAtr.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getEstado().toString()));
        colCapacidadAtr.setCellValueFactory(d ->
                new SimpleStringProperty(String.valueOf(d.getValue().getCapacidadMaxima())));
        colEstaturaAtr.setCellValueFactory(d ->
                new SimpleStringProperty(String.valueOf(d.getValue().getEstaturaMinima())));
    }

    private void configurarSeleccion() {
        tablaAtracciones.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionada) -> {
                    if (seleccionada != null) {
                        txtCodigoAtr.setText(seleccionada.getCodigo());
                        txtNombreAtr.setText(seleccionada.getNombre());
                        txtCapacidadAtr.setText(String.valueOf(seleccionada.getCapacidadMaxima()));
                        txtEstaturaAtr.setText(String.valueOf(seleccionada.getEstaturaMinima()));
                        txtEdadAtr.setText(String.valueOf(seleccionada.getEdadMinima()));
                        txtCostoAtr.setText(String.valueOf(seleccionada.getCostoAdicional()));
                        cmbTipoAtr.setValue(seleccionada.getTipo());
                        cmbZonaAtr.setValue(seleccionada.getZona());
                        txtCodigoAtr.setDisable(true);
                        modoCrear = false;
                        lblMensajeAtr.setText("");
                    }
                });
    }

    private void cargarDatos() {
        cmbZonaAtr.setItems(FXCollections.observableArrayList(adminController.getZonas()));
        cargarAtracciones();
    }

    private void cargarAtracciones() {
        tablaAtracciones.setItems(
                FXCollections.observableArrayList(adminController.getAtracciones())
        );
    }

    @FXML
    private void guardarAtraccion() {
        String codigo = txtCodigoAtr.getText().trim();
        String nombre = txtNombreAtr.getText().trim();
        String capacidadStr = txtCapacidadAtr.getText().trim();
        String estaturaStr = txtEstaturaAtr.getText().trim();
        String edadStr = txtEdadAtr.getText().trim();
        String costoStr = txtCostoAtr.getText().trim();
        TipoAtraccion tipo = cmbTipoAtr.getValue();
        Zona zona = cmbZonaAtr.getValue();

        if (codigo.isEmpty() || nombre.isEmpty() || capacidadStr.isEmpty() ||
                estaturaStr.isEmpty() || edadStr.isEmpty() ||
                costoStr.isEmpty() || tipo == null || zona == null) {
            mostrarError("Completa todos los campos.");
            return;
        }

        try {
            int capacidad = Integer.parseInt(capacidadStr);
            double estatura = Double.parseDouble(estaturaStr);
            int edad = Integer.parseInt(edadStr);
            double costo = Double.parseDouble(costoStr);

            if (modoCrear) {
                boolean agregada = adminController.agregarAtraccion(
                        codigo, nombre, capacidad, estatura, edad, costo, tipo);
                if (agregada) {
                    // Asignar zona a la atracción recién creada
                    adminController.getAtracciones().stream()
                            .filter(a -> a.getCodigo().equals(codigo))
                            .findFirst()
                            .ifPresent(a -> a.setZona(zona));
                    mostrarExito("✓ Atracción creada correctamente.");
                } else {
                    mostrarError("Ya existe una atracción con ese código.");
                    return;
                }
            } else {
                Atraccion seleccionada = tablaAtracciones.getSelectionModel().getSelectedItem();
                if (seleccionada != null) {
                    seleccionada.setNombre(nombre);
                    seleccionada.setCapacidadMaxima(capacidad);
                    seleccionada.setEstaturaMinima(estatura);
                    seleccionada.setEdadMinima(edad);
                    seleccionada.setCostoAdicional(costo);
                    seleccionada.setTipo(tipo);
                    seleccionada.setZona(zona);
                    mostrarExito("✓ Atracción actualizada correctamente.");
                }
            }
            cargarAtracciones();
            limpiarAtr();

        } catch (NumberFormatException e) {
            mostrarError("Verifica que los campos numéricos sean válidos.");
        }
    }

    @FXML
    private void eliminarAtraccion() {
        Atraccion seleccionada = tablaAtracciones.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarError("Selecciona una atracción de la tabla.");
            return;
        }
        adminController.eliminarAtraccion(seleccionada.getCodigo());
        cargarAtracciones();
        mostrarExito("✓ Atracción eliminada correctamente.");
        limpiarAtr();
    }

    @FXML
    private void limpiarAtr() {
        txtCodigoAtr.clear();
        txtCodigoAtr.setDisable(false);
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