package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicioViewController {
    @FXML private Label lblNombreParque;
    @FXML private Label lblDireccion;
    @FXML private Label lblAforo;
    @FXML private Button btnVisitante;
    @FXML private Button btnOperador;
    @FXML private Button btnAdministrador;

    @FXML
    public void initialize() {
        // aquí daniel conecta el parque después
    }

    @FXML
    private void irAVisitante() throws Exception{
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/visitante-bienvenida.fxml")
        );
        Stage stage = (Stage) btnVisitante.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void irAOperador() throws Exception{
       // FXMLLoader loader = new FXMLLoader(
         //       getClass().getResource()
       // )
    }

    @FXML
    private void irAAdministrador() { }
}
