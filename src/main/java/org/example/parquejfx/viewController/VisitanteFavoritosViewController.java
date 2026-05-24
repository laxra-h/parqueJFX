package org.example.parquejfx.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.Atraccion;
import org.example.parquejfx.model.Visitante;
import org.example.parquejfx.model.Zona;

public class VisitanteFavoritosViewController {

    @FXML private ComboBox<Atraccion> cmbAtracciones;
    @FXML private Button btnAgregar;
    @FXML private TableView<Atraccion> tablaFavoritos;
    @FXML private TableColumn<Atraccion, String> colFavNombre;
    @FXML private TableColumn<Atraccion, String> colFavZona;
    @FXML private TableColumn<Atraccion, String> colFavEstado;
    @FXML private TableColumn<Atraccion, String> colFavEspera;
    @FXML private Button btnEliminarFavorito;

    private App app;
    private Visitante visitanteActual;
    private VisitanteController visitanteController;

    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
    }

    public void setApp(App app) {
        this.app = app;
        this.visitanteController = new VisitanteController(app.parque);
        cargarComboBox();
        cargarFavoritos();
    }

    @FXML
    public void initialize() {
        tablaFavoritos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        configurarColumnas();
        configurarComboBox();
    }

    private void configurarColumnas() {
        colFavNombre.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colFavZona.setCellValueFactory(d -> {
            Zona zona = d.getValue().getZona();
            return new SimpleStringProperty(zona != null ? zona.getNombre() : "Sin zona");
        });
        colFavEstado.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getEstado().toString()));
        colFavEspera.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTiempoEspera() + " min"));
    }

    private void configurarComboBox() {
        cmbAtracciones.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Atraccion a, boolean empty) {
                super.updateItem(a, empty);
                setText(empty || a == null ? null : a.getNombre());
            }
        });
        cmbAtracciones.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Atraccion a, boolean empty) {
                super.updateItem(a, empty);
                setText(empty || a == null ? "Selecciona una atracción" : a.getNombre());
            }
        });
    }

    private void cargarComboBox() {
        cmbAtracciones.setItems(
                FXCollections.observableArrayList(app.parque.getListAtracciones())
        );
    }

    private void cargarFavoritos() {
        tablaFavoritos.setItems(
                FXCollections.observableArrayList(visitanteController.getFavoritos(visitanteActual))
        );
    }

    @FXML
    private void agregarFavorito() {
        Atraccion seleccionada = cmbAtracciones.getValue();
        if (seleccionada == null) return;

        boolean agregada = visitanteController.agregarFavorito(visitanteActual, seleccionada);
        if (agregada) {
            tablaFavoritos.getItems().add(seleccionada);
            cmbAtracciones.setValue(null);
        }
    }

    @FXML
    private void eliminarFavorito() {
        Atraccion seleccionada = tablaFavoritos.getSelectionModel().getSelectedItem();
        if (seleccionada == null) return;

        visitanteController.eliminarFavorito(visitanteActual, seleccionada);
        tablaFavoritos.getItems().remove(seleccionada);
    }
}