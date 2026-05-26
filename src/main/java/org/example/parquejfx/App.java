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
// ── ZONAS ────────────────────────────────────────────────────────
        Zona zonaSplash   = new Zona("Splash", 500);
        Zona zonaFantasia = new Zona("Fantasia", 500);
        Zona zonaAventura = new Zona("Aventura", 500);

// ── ATRACCIONES (3 por zona) ──────────────────────────────────────
// Splash - acuáticas
        Atraccion rioSalvaje   = new Atraccion("A01", "Rio Salvaje",   30, 1.40, 8,  3000, 5, 0, 15, EstadoAtraccion.ACTIVA, TipoAtraccion.ACUATICA,           MotivoCierre.CLIMA);
        Atraccion tobogan      = new Atraccion("A02", "Tobogan Gigante",  20, 1.20, 6,  2000, 5, 0, 10, EstadoAtraccion.ACTIVA, TipoAtraccion.ACUATICA,           MotivoCierre.CLIMA);
        Atraccion splashAdventure  = new Atraccion("A03", "Splash adventure",  50, 0.00, 4,  1500, 0, 0, 5,  EstadoAtraccion.ACTIVA, TipoAtraccion.ACUATICA,           MotivoCierre.CLIMA);

// Fantasia - infantiles
        Atraccion carrusel     = new Atraccion("A04", "Carrusel",      40, 0.00, 3,  1000, 0, 0, 5,  EstadoAtraccion.ACTIVA, TipoAtraccion.INFANTIL,           MotivoCierre.MANTENIMIENTO);
        Atraccion trenFantasia = new Atraccion("A05", "Tren Infantil", 30, 0.00, 4,  1200, 0, 0, 8,  EstadoAtraccion.ACTIVA, TipoAtraccion.INFANTIL,           MotivoCierre.MANTENIMIENTO);
        Atraccion miniAutos   = new Atraccion("A06", "Mini autos chocones",20,1.50, 12, 2500, 5, 0, 12, EstadoAtraccion.ACTIVA, TipoAtraccion.INFANTIL,           MotivoCierre.MANTENIMIENTO);

// Aventura - mecánicas de altura
        Atraccion montanaRusa  = new Atraccion("A07", "Montana Rusa",  25, 1.50, 12, 5000, 10, 0, 20, EstadoAtraccion.ACTIVA, TipoAtraccion.MECANICA_DE_ALTURA, MotivoCierre.CLIMA);
        Atraccion torreLibre   = new Atraccion("A08", "Torre Libre",   15, 1.55, 14, 4500, 10, 0, 25, EstadoAtraccion.ACTIVA, TipoAtraccion.MECANICA_DE_ALTURA, MotivoCierre.CLIMA);
        Atraccion tren    = new Atraccion("A09", "Tren minero",     20, 1.45, 10, 4000, 10, 0, 18, EstadoAtraccion.ACTIVA, TipoAtraccion.MECANICA_DE_ALTURA, MotivoCierre.CLIMA);

// Asignar atracciones a zonas
        rioSalvaje.setZona(zonaSplash);
        tobogan.setZona(zonaSplash);
        splashAdventure.setZona(zonaSplash);

        carrusel.setZona(zonaFantasia);
        trenFantasia.setZona(zonaFantasia);
        miniAutos.setZona(zonaFantasia);

        montanaRusa.setZona(zonaAventura);
        torreLibre.setZona(zonaAventura);
        tren.setZona(zonaAventura);

// Agregar atracciones al parque
        parque.getListAtracciones().add(rioSalvaje);
        parque.getListAtracciones().add(tobogan);
        parque.getListAtracciones().add(splashAdventure);
        parque.getListAtracciones().add(carrusel);
        parque.getListAtracciones().add(trenFantasia);
        parque.getListAtracciones().add(miniAutos);
        parque.getListAtracciones().add(montanaRusa);
        parque.getListAtracciones().add(torreLibre);
        parque.getListAtracciones().add(tren);

// Agregar zonas al parque
        parque.getListZonas().add(zonaSplash);
        parque.getListZonas().add(zonaFantasia);
        parque.getListZonas().add(zonaAventura);

// ── OPERADORES (3 por zona) ───────────────────────────────────────
        Operador op1 = new Operador("Carlos",  "OP01", "123", zonaSplash);
        Operador op2 = new Operador("Maria",   "OP02", "123", zonaSplash);
        Operador op3 = new Operador("Luis",    "OP03", "123", zonaSplash);

        Operador op4 = new Operador("Ana",     "OP04", "123", zonaFantasia);
        Operador op5 = new Operador("Pedro",   "OP05", "123", zonaFantasia);
        Operador op6 = new Operador("Sofia",   "OP06", "123", zonaFantasia);

        Operador op7 = new Operador("Jorge",   "OP07", "123", zonaAventura);
        Operador op8 = new Operador("Laura",   "OP08", "123", zonaAventura);
        Operador op9 = new Operador("Miguel",  "OP09", "123", zonaAventura);

        parque.getListEmpleados().add(op1);
        parque.getListEmpleados().add(op2);
        parque.getListEmpleados().add(op3);
        parque.getListEmpleados().add(op4);
        parque.getListEmpleados().add(op5);
        parque.getListEmpleados().add(op6);
        parque.getListEmpleados().add(op7);
        parque.getListEmpleados().add(op8);
        parque.getListEmpleados().add(op9); 

// ── VISITANTES ────────────────────────────────────────────────────
        Visitante v1 = new Visitante("Juan",     "V001", "123", 25, 1.90, 50000);
        Visitante v2 = new Visitante("Camila",   "V002", "123", 22, 1.60, 30000);
        Visitante v3 = new Visitante("Santiago", "V003", "123", 30, 1.80, 80000);
        Visitante v4 = new Visitante("Valentina","V004", "123", 17, 1.55, 20000);
        Visitante v5 = new Visitante("Andres",   "V005", "123", 14, 1.40, 15000);
        Visitante v6 = new Visitante("Isabella", "V006", "123", 10, 1.20, 10000);
        Visitante v7 = new Visitante("Nicolas",  "V007", "123", 35, 1.70, 60000);
        Visitante v8 = new Visitante("Mariana",  "V008", "123", 28, 1.65, 45000);

        parque.getListVisitantes().add(v1);
        parque.getListVisitantes().add(v2);
        parque.getListVisitantes().add(v3);
        parque.getListVisitantes().add(v4);
        parque.getListVisitantes().add(v5);
        parque.getListVisitantes().add(v6);
        parque.getListVisitantes().add(v7);
        parque.getListVisitantes().add(v8);

// ── ADMINISTRADOR ─────────────────────────────────────────────────
        Administrador admin = new Administrador("Admin Principal", "ADM01", "admin123");
        parque.getListEmpleados().add(admin);
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