package org.example.parquejfx.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class VisitanteNotificacionesViewController {

    @FXML private ListView<String> listaNotificaciones;
    @FXML private Label lblContadorNotif;
    @FXML private Button btnLimpiar;

    // Notificaciones de prueba hasta conectar el model (quemados)
    private final ObservableList<String> notificaciones =
            FXCollections.observableArrayList(
                    "[" + LocalDate.now() + "] Splash Adventure cerrada por condiciones climáticas.",
                    "[" + LocalDate.now() + "] Tren Minero en mantenimiento preventivo.",
                    "[" + LocalDate.now() + "] ¡Show de acrobacias a las 4:00 PM en Zona Aventura!",
                    "[" + LocalDate.now() + "] Montaña Rusa operando con normalidad.",
                    "[" + LocalDate.now() + "] Alerta climática activa — atracciones acuáticas cerradas."
            );

    @FXML
    public void initialize() {
        listaNotificaciones.setItems(notificaciones);
        actualizarContador();
    }

    @FXML
    private void limpiarNotificaciones() {
        notificaciones.clear();
        actualizarContador();
    }

    private void actualizarContador() {
        int total = notificaciones.size();
        lblContadorNotif.setText(total + (total == 1
                ? " notificación"
                : " notificaciones"));
    }
}