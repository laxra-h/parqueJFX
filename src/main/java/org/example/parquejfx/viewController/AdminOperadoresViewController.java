package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.Operador;
import org.example.parquejfx.model.Zona;

public class AdminOperadoresViewController {

    @FXML private ComboBox<Operador> cmbOperador;
    @FXML private ComboBox<Zona> cmbZonaOperador;
    @FXML private Label lblMensajeOp;
    @FXML private TableView<Operador> tablaAsignaciones;
    @FXML private TableColumn<Operador, String> colOperador;
    @FXML private TableColumn<Operador, String> colZonaOp;

    private AdminController adminController;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        cargarDatos();
    }

    @FXML
    public void initialize() {
        configurarColumnas();
        configurarCombos();
        configurarSeleccion();
    }

    private void configurarCombos() {
        cmbOperador.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Operador o, boolean empty) {
                super.updateItem(o, empty);
                setText(empty || o == null ? null : o.getNombre());
            }
        });
        cmbOperador.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Operador o, boolean empty) {
                super.updateItem(o, empty);
                setText(empty || o == null ? "Selecciona un operador" : o.getNombre());
            }
        });

        cmbZonaOperador.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Zona z, boolean empty) {
                super.updateItem(z, empty);
                setText(empty || z == null ? null : z.getNombre());
            }
        });
        cmbZonaOperador.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Zona z, boolean empty) {
                super.updateItem(z, empty);
                setText(empty || z == null ? "Selecciona una zona" : z.getNombre());
            }
        });
    }

    private void configurarColumnas() {
        colOperador.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colZonaOp.setCellValueFactory(d -> {
            Zona zona = d.getValue().getZonaAsignada();
            return new SimpleStringProperty(zona != null ? zona.getNombre() : "Sin zona");
        });
    }

    private void configurarSeleccion() {
        tablaAsignaciones.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        cmbOperador.setValue(seleccionado);
                        cmbZonaOperador.setValue(seleccionado.getZonaAsignada());
                        lblMensajeOp.setText("");
                    }
                });
    }

    private void cargarDatos() {
        cmbOperador.setItems(FXCollections.observableArrayList(adminController.getOperadores()));
        cmbZonaOperador.setItems(FXCollections.observableArrayList(adminController.getZonas()));
        cargarTabla();
    }

    private void cargarTabla() {
        // Muestra solo operadores que ya tienen zona asignada
        tablaAsignaciones.setItems(
                FXCollections.observableArrayList(
                        adminController.getOperadores().stream()
                                .filter(o -> o.getZonaAsignada() != null)
                                .toList()
                )
        );
    }

    @FXML
    private void asignarOperador() {
        Operador operador = cmbOperador.getValue();
        Zona zona = cmbZonaOperador.getValue();

        if (operador == null || zona == null) {
            mostrarError("Selecciona un operador y una zona.");
            return;
        }

        boolean asignado = adminController.asignarOperador(operador.getCedula(), zona.getNombre());
        if (asignado) {
            mostrarExito("✓ " + operador.getNombre() + " asignado a " + zona.getNombre());
            cargarTabla();
            limpiar();
        } else {
            mostrarError(operador.getNombre() + " ya tiene una zona asignada.");
        }
    }

    @FXML
    private void desasignarOperador() {
        Operador seleccionado = tablaAsignaciones.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Selecciona una asignación de la tabla.");
            return;
        }
        adminController.desasignarOperador(seleccionado.getCedula());
        cargarTabla();
        mostrarExito("✓ Asignación eliminada correctamente.");
        limpiar();
    }

    private void limpiar() {
        cmbOperador.setValue(null);
        cmbZonaOperador.setValue(null);
        tablaAsignaciones.getSelectionModel().clearSelection();
        lblMensajeOp.setText("");
    }

    private void mostrarError(String mensaje) {
        lblMensajeOp.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeOp.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajeOp.setStyle("-fx-text-fill: #1E8449;");
        lblMensajeOp.setText(mensaje);
    }
}