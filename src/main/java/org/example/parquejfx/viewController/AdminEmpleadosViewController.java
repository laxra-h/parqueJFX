package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.controller.AdminController;
import org.example.parquejfx.model.Empleado;
import org.example.parquejfx.model.Operador;
import org.example.parquejfx.model.Administrador;

public class AdminEmpleadosViewController {

    @FXML private TextField txtIdEmp;
    @FXML private TextField txtNombreEmp;
    @FXML private TextField txtContraseniaEmp;
    @FXML private ComboBox<String> cmbRolEmp;
    @FXML private Label lblMensajeEmp;
    @FXML private TableView<Empleado> tablaEmpleados;
    @FXML private TableColumn<Empleado, String> colIdEmp;
    @FXML private TableColumn<Empleado, String> colNombreEmp;
    @FXML private TableColumn<Empleado, String> colRolEmp;

    private AdminController adminController;
    private boolean modoCrear = true;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
        cargarEmpleados();
    }

    @FXML
    public void initialize() {
        cmbRolEmp.setItems(FXCollections.observableArrayList("Operador", "Administrador"));
        configurarColumnas();
        configurarSeleccion();
    }

    private void configurarColumnas() {
        colIdEmp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getCedula()));
        colNombreEmp.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colRolEmp.setCellValueFactory(d -> {
            Empleado e = d.getValue();
            String rol = e instanceof Administrador ? "Administrador" : "Operador";
            return new SimpleStringProperty(rol);
        });
    }

    private void configurarSeleccion() {
        tablaEmpleados.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        txtIdEmp.setText(seleccionado.getCedula());
                        txtNombreEmp.setText(seleccionado.getNombre());
                        cmbRolEmp.setValue(seleccionado instanceof Administrador ? "Administrador" : "Operador");
                        txtIdEmp.setDisable(true);
                        modoCrear = false;
                        lblMensajeEmp.setText("");
                    }
                });
    }

    private void cargarEmpleados() {
        tablaEmpleados.setItems(
                FXCollections.observableArrayList(adminController.getEmpleados())
        );
    }

    @FXML
    private void guardarEmpleado() {
        String cedula = txtIdEmp.getText().trim();
        String nombre = txtNombreEmp.getText().trim();
        String contrasenia = txtContraseniaEmp.getText().trim();
        String rol = cmbRolEmp.getValue();

        if (cedula.isEmpty() || nombre.isEmpty() || contrasenia.isEmpty() || rol == null) {
            mostrarError("Completa todos los campos.");
            return;
        }

        if (modoCrear) {
            boolean agregado = rol.equals("Operador")
                    ? adminController.agregarOperador(nombre, cedula, contrasenia)
                    : adminController.agregarAdministrador(nombre, cedula, contrasenia);

            if (agregado) {
                mostrarExito("✓ Empleado creado correctamente.");
                cargarEmpleados();
                limpiarEmp();
            } else {
                mostrarError("Ya existe un empleado con esa cédula.");
            }
        }
    }

    @FXML
    private void eliminarEmpleado() {
        Empleado seleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarError("Selecciona un empleado de la tabla.");
            return;
        }
        adminController.eliminarEmpleado(seleccionado.getCedula());
        cargarEmpleados();
        mostrarExito("✓ Empleado eliminado.");
        limpiarEmp();
    }

    @FXML
    private void limpiarEmp() {
        txtIdEmp.clear();
        txtIdEmp.setDisable(false);
        txtNombreEmp.clear();
        txtContraseniaEmp.clear();
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