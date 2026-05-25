package org.example.parquejfx.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class VisitanteTest {



    private static final Logger logger = Logger.getLogger(Visitante.class.getName());

    private Parque parque;
    private Administrador admin;
    private Zona zona;
    private Visitante visitante1;
    private Ticket theTicket1;
    private Atraccion atraccion1;
    private Atraccion atraccion2;

    @BeforeEach
    public void preparar(){
        parque = new Parque("1031", "david", "calle 12", 1000);
        parque.createAdmin("daniel", "1054", "1064");
        int posicion = parque.buscarEmpleado("1054");
        admin = (Administrador) parque.getListEmpleados().get(posicion);
        admin.setParque(parque);
        visitante1 = new Visitante("David", "1031", "1054", 18, 1.89, 350000);
        admin.createZona("lala", 500);
        int posicion1 = admin.buscarZona("lala");
        zona = parque.getListZonas().get(posicion1);
        admin.createAtraccion("1054", "lulu", 100, 1.54, 15, 200, 15, 15, EstadoAtraccion.ACTIVA, TipoAtraccion.MECANICA_DE_ALTURA,    MotivoCierre.NO_APLICA,zona );
        int posicion2 = admin.buscarAtraccion("1054");
        atraccion1 = parque.getListAtracciones().get(posicion2);

        admin.createAtraccion("1054", "lala", 100, 1.54, 15, 200, 15, 15, EstadoAtraccion.ACTIVA, TipoAtraccion.MECANICA_DE_ALTURA,    MotivoCierre.NO_APLICA, zona);
        int posicion3 = admin.buscarAtraccion("1054");
        atraccion2 = parque.getListAtracciones().get(posicion3);
        zona.agregarAtraccion(atraccion1);
        zona.agregarAtraccion(atraccion2);
    }

    @Test
    public void registroTicket(){

        boolean resultado = visitante1.comprarGeneral();

        assertTrue(resultado);
    }


    @Test
    public void registroFamiliar(){
        boolean resultado = visitante1.comprarFamiliar(12);
        assertTrue(resultado);
    }


    @Test
    public void registroListaFav(){

        boolean resultado = visitante1.agregarAtraccionFavorita("lulu");

        assertTrue(resultado);
    }

}