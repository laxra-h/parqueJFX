package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminEmpleadosViewController {

    @FXML private TextField txtIdEmp;
    @FXML private TextField txtNombreEmp;
    @FXML private ComboBox<String> cmbRolEmp;
    @FXML private Label lblMensajeEmp;
    @FXML private Button btnGuardarEmp;
    @FXML private Button btnLimpiarEmp;
    @FXML private Button btnEliminarEmp;

    @FXML private TableView<String[]> tablaEmpleados;
    @FXML private TableColumn<String[], String> colIdEmp;
    @FXML private TableColumn<String[], String> colNombreEmp;
    @FXML private TableColumn<String[], String> colRolEmp;

    private final ObservableList<String[]> empleados =
            FXCollections.observableArrayList();

    // true = creando nuevo, false = editando existente
    private boolean modoCrear = true;

    @FXML
    public void initialize() {
        cmbRolEmp.setItems(FXCollections.observableArrayList(
                "Operador", "Administrador"
        ));
        configurarColumnas();
        tablaEmpleados.setItems(empleados);
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colIdEmp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[0]));
        colNombreEmp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[1]));
        colRolEmp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue()[2]));
    }

    // Cuando se selecciona una fila llena el formulario
    private void configurarSeleccion() {
        tablaEmpleados.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        txtIdEmp.setText(seleccionado[0]);
                        txtNombreEmp.setText(seleccionado[1]);
                        cmbRolEmp.setValue(seleccionado[2]);
                        txtIdEmp.setDisable(true);
                        modoCrear = false;
                        lblMensajeEmp.setText("");
                    }
                });
    }

    @FXML
    private void guardarEmpleado() {
        String id = txtIdEmp.getText().trim();
        String nombre = txtNombreEmp.getText().trim();
        String rol = cmbRolEmp.getValue();

        if (id.isEmpty() || nombre.isEmpty() || rol == null) {
            mostrarError("Completa todos los campos.");
            return;
        }

        if (modoCrear) {
            // Verificar que el ID no exista
            for (String[] e : empleados) {
                if (e[0].equals(id)) {
                    mostrarError("Ya existe un empleado con ese ID.");
                    return;
                }
            }
            empleados.add(new String[]{id, nombre, rol});
            mostrarExito("✓ Empleado creado correctamente.");
        } else {
            // Actualizar el empleado seleccionado
            String[] seleccionado = tablaEmpleados
                    .getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                seleccionado[1] = nombre;
                seleccionado[2] = rol;
                tablaEmpleados.refresh();
                mostrarExito("✓ Empleado actualizado.");
            }
        }
        limpiarEmp();
    }

    @FXML
    private void eliminarEmpleado() {
        String[] seleccionado = tablaEmpleados
                .getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Selecciona un empleado de la tabla.");
            return;
        }
        empleados.remove(seleccionado);
        mostrarExito("✓ Empleado eliminado.");
        limpiarEmp();
    }

    @FXML
    private void limpiarEmp() {
        txtIdEmp.clear();
        txtIdEmp.setDisable(false);
        txtNombreEmp.clear();
        cmbRolEmp.setValue(null);
        tablaEmpleados.getSelectionModel().clearSelection();
        modoCrear = true;
        lblMensajeEmp.setText("");
    }

    private void mostrarError(String mensaje) {
        lblMensajeEmp.setStyle("-fx-text-fill: #C0392B;");
        lblMensajeEmp.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajeEmp.setStyle("-fx-text-fill: #1E8449;");
        lblMensajeEmp.setText(mensaje);
    }
}