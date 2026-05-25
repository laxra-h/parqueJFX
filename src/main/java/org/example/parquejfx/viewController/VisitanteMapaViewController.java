package org.example.parquejfx.viewController;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VisitanteMapaViewController {

    @FXML private ImageView imgMapa;

    @FXML
    public void initialize() {
        Image imagen = new Image(
                getClass().getResourceAsStream("/org/example/parquejfx/mapa-parque.png")
        );
        imgMapa.setImage(imagen);
    }
}
