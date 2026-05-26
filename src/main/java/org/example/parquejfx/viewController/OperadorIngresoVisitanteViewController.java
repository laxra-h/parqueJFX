package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.parquejfx.controller.OperadorController;

public class OperadorIngresoVisitanteViewController {

        @FXML private Button btnGenerar;
        @FXML private Button btnVolver;
        @FXML private TextField txtDocumento;

        private OperadorController operadorController;

        public void setOperadorController(OperadorController operadorController) {
                this.operadorController = operadorController;
        }

        @FXML
        void generar(ActionEvent event) {
                String cedula = txtDocumento.getText().trim();

                if (cedula.isEmpty()) {
                        mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío", "Por favor ingresa el número de cédula.");
                        return;
                }

                if (!operadorController.visitanteExiste(cedula)) {
                        mostrarAlerta(Alert.AlertType.ERROR, "Visitante no encontrado",
                                "No existe un visitante registrado con la cédula: " + cedula);
                        return;
                }

                boolean acceso = operadorController.verificarAccesoVisitante(cedula);

                if (acceso) {
                        mostrarAlerta(Alert.AlertType.INFORMATION, "Acceso permitido ✅",
                                "El visitante cumple los requisitos. Ingreso registrado correctamente.");
                        txtDocumento.clear();
                } else {
                        mostrarAlerta(Alert.AlertType.ERROR, "Acceso denegado ❌",
                                "El visitante no cumple los requisitos de estatura o edad mínima para esta atracción.");
                }
        }

        @FXML
        void volver(ActionEvent event) {
                try {
                        // Ajusta según tu método cargarVista del panel
                        btnVolver.getScene().getWindow(); // vuelve al panel
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
                Alert alert = new Alert(tipo);
                alert.setTitle(titulo);
                alert.setHeaderText(null);
                alert.setContentText(mensaje);
                alert.showAndWait();
        }
}