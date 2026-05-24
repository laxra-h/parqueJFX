package org.example.parquejfx.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import org.example.parquejfx.App;
import org.example.parquejfx.controller.VisitanteController;
import org.example.parquejfx.model.*;

import java.util.ArrayList;
import java.util.List;

public class VisitanteAtraccionesViewController {

    @FXML private TableView<Atraccion> tablaAtracciones;
    @FXML private TableColumn<Atraccion, String> colNombre;
    @FXML private TableColumn<Atraccion, String> colZona;
    @FXML private TableColumn<Atraccion, String> colTipo;
    @FXML private TableColumn<Atraccion, String> colEstado;
    @FXML private TableColumn<Atraccion, String> colEspera;
    @FXML private TableColumn<Atraccion, String> colEstatura;

    @FXML private Button btnFiltroTodas;

    private App app;
    private Visitante visitanteActual;
    private VisitanteController visitanteController;

    public void setVisitanteActual(Visitante visitanteActual) {
        this.visitanteActual = visitanteActual;
    }

    public void setApp(App app) {
        this.app = app;
        this.visitanteController = new VisitanteController(app.parque);
        cargarTodas();
    }

    @FXML
    public void initialize() {
        tablaAtracciones.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        configurarColumnas();
    }

    private void configurarColumnas() {
        colNombre.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getNombre()));
        colZona.setCellValueFactory(d -> {
            Zona zona = d.getValue().getZona();
            return new SimpleStringProperty(zona != null ? zona.getNombre() : "Sin zona");
        });
        colTipo.setCellValueFactory(d -> {
            TipoAtraccion tipo = d.getValue().getTipo();
            return new SimpleStringProperty(tipo != null ? tipo.toString() : "Sin tipo");
        });
        colEstado.setCellValueFactory(d -> {
            EstadoAtraccion estado = d.getValue().getEstado();
            return new SimpleStringProperty(estado != null ? estado.toString() : "Sin estado");
        });
        colEspera.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getTiempoEspera() + " min"));
        colEstatura.setCellValueFactory(d ->
                new SimpleStringProperty(d.getValue().getEstaturaMinima() + "m"));
    }

    private void cargarTodas() {
        tablaAtracciones.setItems(
                FXCollections.observableArrayList(app.parque.getListAtracciones())
        );
    }


    @FXML
    void filtrarTodas() {
        cargarTodas();
    }
}