package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.model.Atraccion;

public class OperadorIngresoVisitanteViewController {

        @FXML private Button btnValidar;
        @FXML private Button btnVolver;
        @FXML private TextField txtDocumento;

        private OperadorController operadorController;

        public void setOperadorController(OperadorController operadorController) {
                this.operadorController = operadorController;
        }

        @FXML
        void validar(ActionEvent event) {
                String cedula = txtDocumento.getText().trim();

                if (cedula.isEmpty()) {
                        mostrarAlerta(Alert.AlertType.WARNING, "Campo vacío",
                                "Por favor ingresa el número de cédula del visitante.");
                        return;
                }

                if (!operadorController.visitanteExiste(cedula)) {
                        mostrarAlerta(Alert.AlertType.ERROR, "Visitante no encontrado",
                                "No existe un visitante con la cédula: " + cedula);
                        return;
                }

                boolean acceso = operadorController.verificarAccesoVisitante(cedula);

                if (acceso) {
                        int contador = operadorController.getVisitantesAcumulados();
                        String mensaje = "Ingreso registrado correctamente. Visitantes acumulados: " + contador;

                        // Avisar si la atracción fue cerrada por llegar a 500
                        if (contador >= 500) {
                                mensaje += "\n⚠ La atracción ha alcanzado 500 visitantes y fue cerrada para mantenimiento.";
                        }

                        mostrarAlerta(Alert.AlertType.INFORMATION, "✅ Acceso permitido", mensaje);
                        txtDocumento.clear();
                } else {
                        Atraccion atraccion = operadorController.getAtraccionAsignada();
                        String requisitos = atraccion != null
                                ? "\nEstatura mínima: " + atraccion.getEstaturaMinima() + " m"
                                + "\nEdad mínima: " + atraccion.getEdadMinima() + " años"
                                : "";
                        mostrarAlerta(Alert.AlertType.ERROR, "❌ Acceso denegado",
                                "El visitante no cumple los requisitos." + requisitos);
                }
        }

        @FXML
        void volver(ActionEvent event) {
                // La navegación la maneja el panel
        }

        private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
                Alert alert = new Alert(tipo);
                alert.setTitle(titulo);
                alert.setHeaderText(null);
                alert.setContentText(mensaje);
                alert.showAndWait();
        }
}