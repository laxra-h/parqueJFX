package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.Visitante;

public class VisitantePerfilViewController {

    @FXML private ImageView imgPerfil;
    @FXML private Label lblNombrePerfil;
    @FXML private Label lblDocumentoPerfil;
    @FXML private TextField txtNombrePerfil;
    @FXML private TextField txtEdadPerfil;
    @FXML private TextField txtEstaturaPerfil;
    @FXML private PasswordField txtContrasenaPerfil;
    @FXML private Label lblMensajePerfil;
    @FXML private Label lblEstaturaPerfil;
    @FXML private Label lblEdadPerfil;
    @FXML private Label lblTicketPerfil;
    @FXML private Label lblSaldoPerfil;

    private App app;
    private Visitante visitanteActual;
    private VisitanteController visitanteController;

    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
    }

    public void setApp(App app) {
        this.app = app;
        this.visitanteController = new VisitanteController(app.parque);
        cargarDatos();
    }

    @FXML
    public void initialize() {
        Image imagen = new Image(
                getClass().getResourceAsStream("/org/example/parquejfx/perfil-default.png")
        );
        imgPerfil.setImage(imagen);
    }

    private void cargarDatos() {
        lblNombrePerfil.setText(visitanteActual.getNombre());
        lblDocumentoPerfil.setText("CC: " + visitanteActual.getCedula());
        txtNombrePerfil.setText(visitanteActual.getNombre());
        txtEdadPerfil.setText(String.valueOf(visitanteActual.getEdad()));
        txtEstaturaPerfil.setText(String.valueOf(visitanteActual.getEstatura()));
        lblEstaturaPerfil.setText("Estatura" + String.valueOf(visitanteActual.getEstatura()));
        lblEdadPerfil.setText("Edad: " + visitanteActual.getEdad());
        lblTicketPerfil.setText("Ticket: " + visitanteActual.getTheTicket().toString());
        lblSaldoPerfil.setText("Saldo: " + visitanteActual.getSaldoVirtual());

    }

    @FXML
    private void guardarCambios() {
        if (txtNombrePerfil.getText().isEmpty() ||
                txtEdadPerfil.getText().isEmpty() ||
                txtEstaturaPerfil.getText().isEmpty()) {
            mostrarError("Completa los campos obligatorios.");
            return;
        }
        try {
            int edad = Integer.parseInt(txtEdadPerfil.getText().trim());
            double estatura = Double.parseDouble(txtEstaturaPerfil.getText().trim());

            visitanteController.actualizarPerfil(
                    visitanteActual, txtNombrePerfil.getText().trim(), edad, estatura
            );

            visitanteController.actualizarContrasenia(visitanteActual, txtContrasenaPerfil.getText().trim());
            lblNombrePerfil.setText(visitanteActual.getNombre());
            txtContrasenaPerfil.clear();
            mostrarExito("✓ Datos actualizados correctamente.");

        } catch (NumberFormatException e) {
            mostrarError("Edad y estatura deben ser números válidos.");
        }
    }

    @FXML
    private void cancelar() {
        cargarDatos();
        txtContrasenaPerfil.clear();
        lblMensajePerfil.setText("");
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