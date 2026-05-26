package org.example.parquejfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.parquejfx.controller.OperadorController;

public class OperadorRecargaViewController {

    @FXML private Button btnRecargar;
    @FXML private Button btnVolver;
    @FXML private TextField txtDocumento;   // cédula
    @FXML private TextField txtDocumento1;  // monto

    private OperadorController operadorController;

    public void setOperadorController(OperadorController operadorController) {
        this.operadorController = operadorController;
    }

    @FXML
    void recargar(ActionEvent event) {
        String cedula = txtDocumento.getText().trim();
        String montoStr = txtDocumento1.getText().trim();

        if (cedula.isEmpty() || montoStr.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos",
                    "Por favor completa la cédula y el valor de recarga.");
            return;
        }

        float monto;
        try {
            monto = Float.parseFloat(montoStr);
            if (monto <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Valor inválido",
                    "El monto debe ser un número positivo.");
            return;
        }

        boolean ok = operadorController.recargarSaldo(cedula, monto);

        if (ok) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Recarga exitosa ✅",
                    "Se recargaron $" + String.format("%,.0f", monto) +
                            " al visitante con cédula " + cedula + ".");
            txtDocumento.clear();
            txtDocumento1.clear();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Visitante no encontrado ❌",
                    "No existe un visitante registrado con la cédula: " + cedula);
        }
    }

    @FXML
    void volver(ActionEvent event) {
        // Igual que en las otras vistas — ajusta según tu cargarVista()
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}