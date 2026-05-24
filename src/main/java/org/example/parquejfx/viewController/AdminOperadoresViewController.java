package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminOperadoresViewController {

    @FXML private ComboBox<String> cmbOperador;
    @FXML private ComboBox<String> cmbZonaOperador;
    @FXML private Label lblMensajeOp;
    @FXML private Button btnAsignar;
    @FXML private Button btnDesasignar;

    @FXML private TableView<String[]> tablaAsignaciones;
    @FXML private TableColumn<String[], String> colOperador;
    @FXML private TableColumn<String[], String> colZonaOp;

    // Operadores de prueba hasta conectar el model
    private final ObservableList<String> operadoresDisponibles =
            FXCollections.observableArrayList(
                    "Carlos Pérez",
                    "María López",
                    "Juan García",
                    "Ana Martínez",
                    "Luis Rodríguez"
            );

    private final ObservableList<String[]> asignaciones =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cmbOperador.setItems(operadoresDisponibles);
        cmbZonaOperador.setItems(FXCollections.observableArrayList(
                "Zona Aventura", "Zona Splash", "Zona Fantasía"
        ));
        configurarColumnas();
        tablaAsignaciones.setItems(asignaciones);
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colOperador.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[0]));
        colZonaOp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[1]));
    }

    private void configurarSeleccion() {
        tablaAsignaciones.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        cmbOperador.setValue(seleccionado[0]);
                        cmbZonaOperador.setValue(seleccionado[1]);
                        lblMensajeOp.setText("");
                    }
                });
    }

    @FXML
    private void asignarOperador() {
        String operador = cmbOperador.getValue();
        String zona = cmbZonaOperador.getValue();

        if (operador == null || zona == null) {
            mostrarError("Selecciona un operador y una zona.");
            return;
        }

        // Verificar si el operador ya tiene asignacion
        for (String[] a : asignaciones) {
            if (a[0].equals(operador)) {
                mostrarError(operador + " ya tiene una zona asignada.");
                return;
            }
        }

        asignaciones.add(new String[]{operador, zona});
        mostrarExito("✓ " + operador + " asignado a " + zona);
        limpiar();
    }

    @FXML
    private void desasignarOperador() {
        String[] seleccionado = tablaAsignaciones
                .getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Selecciona una asignación de la tabla.");
            return;
        }
        asignaciones.remove(seleccionado);
        mostrarExito("✓ Asignación eliminada correctamente.");
        limpiar();
    }

    private void limpiar() {
        cmbOperador.setValue(null);
        cmbZonaOperador.setValue(null);
        tablaAsignaciones.getSelectionModel().clearSelection();
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