package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VisitantePerfilViewController {

    @FXML private ImageView imgPerfil;

    @FXML private Label lblNombrePerfil;
    @FXML private Label lblDocumentoPerfil;

    @FXML private TextField txtNombrePerfil;
    @FXML private TextField txtEdadPerfil;
    @FXML private TextField txtEstaturaPerfil;
    @FXML private PasswordField txtContrasenaPerfil;

    @FXML private Label lblMensajePerfil;
    @FXML private Button btnGuardarPerfil;
    @FXML private Button btnCancelar;

    @FXML private Label lblSaldoPerfil;
    @FXML private TextField txtRecarga;
    @FXML private Button btnRecargar;

    @FXML
    public void initialize() {
        // Carga la imagen de perfil por defecto
        Image imagen = new Image(
                getClass().getResourceAsStream("/org/example/parquejfx/perfil-default.png")
        );
        imgPerfil.setImage(imagen);

        // Datos de prueba hasta conectar el model
        lblNombrePerfil.setText("Laura García");
        lblDocumentoPerfil.setText("CC: 1234567890");
        txtNombrePerfil.setText("Laura García");
        txtEdadPerfil.setText("21");
        txtEstaturaPerfil.setText("165");
        lblSaldoPerfil.setText("$50.000");
    }

    @FXML
    private void guardarCambios() {
        if (txtNombrePerfil.getText().isEmpty() ||
                txtEdadPerfil.getText().isEmpty() ||
                txtEstaturaPerfil.getText().isEmpty()) {
            mostrarError("Completa los campos obligatorios.");
            return;
        }
        lblNombrePerfil.setText(txtNombrePerfil.getText());
        mostrarExito("✓ Datos actualizados correctamente.");
    }

    @FXML
    private void cancelar() {
        txtNombrePerfil.setText("Laura García");
        txtEdadPerfil.setText("21");
        txtEstaturaPerfil.setText("165");
        txtContrasenaPerfil.clear();
        lblMensajePerfil.setText("");
    }

    @FXML
    private void recargarSaldo() {
        String monto = txtRecarga.getText().trim();
        if (monto.isEmpty()) {
            mostrarError("Ingresa un monto para recargar.");
            return;
        }
        try {
            int valor = Integer.parseInt(monto);
            if (valor <= 0) {
                mostrarError("El monto debe ser mayor a $0.");
                return;
            }
            mostrarExito("✓ Saldo recargado: $" + valor);
            txtRecarga.clear();
        } catch (NumberFormatException e) {
            mostrarError("Ingresa solo números en el monto.");
        }
    }

    private void mostrarError(String mensaje) {
        lblMensajePerfil.setStyle("-fx-text-fill: #C0392B;");
        lblMensajePerfil.setText(mensaje);
    }

    private void mostrarExito(String mensaje) {
        lblMensajePerfil.setStyle("-fx-text-fill: #1E8449;");
        lblMensajePerfil.setText(mensaje);
    }
}