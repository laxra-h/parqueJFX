package org.example.parquejfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.model.*;
import org.example.parquejfx.viewController.InicioViewController;

//NO OLVIDAR, ESTABA EN CONEXIÓN Y GURADADO DE VISITANTES

public class App extends Application {
    public Parque parque;
    public OperadorController operadorController;

    @Override
    public void start(Stage stage) throws Exception {
        parque = new Parque("109", "TECH-PARQ UQ", "CLL20", 2000); // ← inicializa el parque
        Operador o = new Operador("Dani", "1092", "123", null);
        parque.getListEmpleados().add(o);
        Visitante v = new Visitante("Lau", "1092", "123", 18, 1.60, 1092);
        parque.getListVisitantes().add(v);
        Administrador admin = new Administrador("Admin", "1234", "4321");
        parque.getListEmpleados().add(admin);

        Zona z = new Zona("nombre", 1900);
        Atraccion a = new Atraccion("01", "n", 12, 1.60, 10, 2500, 5, 0, 10, EstadoAtraccion.ACTIVA, TipoAtraccion.ACUATICA, MotivoCierre.CLIMA );
       a.setZona(z);
        parque.getListAtracciones().add(a);
        parque.getListZonas().add(z);


        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/inicio.fxml")
        );

        Scene scene = new Scene(loader.load());

        InicioViewController ctrl = loader.getController();
        ctrl.setApp(this); // ← inyectas app aquí

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}










/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.parquejfx.model.Parque;

public class App extends Application {
    public static Parque parque = new Parque("123","Uq", "",0);

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/org/example/parquejfx/inicio.fxml")
        );
        Scene scene = new Scene(loader.load());
        stage.setTitle("Tech-Park UQ");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/