package org.example.parquejfx.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.logging.Logger;

class ParqueTest {


    private static final Logger logger = Logger.getLogger(ParqueTest.class.getName());


    Parque parque;
    Visitante visitante1;
    Visitante visitante2;
    Administrador admin;
    Zona zona1;
    Operador operador1;
    Operador operador2;


    @BeforeEach
    public void preparar(){
        parque = new Parque("1031", "LAL", "calle 12", 1000);
        parque.createAdmin("David", "1030", "1032");
        admin = parque.buscarAdminByCedula("1030");
        admin.setParque(parque);
        parque.createVisitante("Daniel", "1031", "1065",15, 1.67, 2500);
        admin.createZona("Zona1", 100);
        int posicion = admin.buscarZona("Zona1");
        zona1 = parque.getListZonas().get(posicion);
        admin.createOperador("Laura", "1050", "1040", zona1);



    }

    @Test
    @DisplayName("Metodo para el correcto registro del visitante")
    public void registroVisitante(){

        logger.info("Inicio de la prueba ");

        boolean resultado = parque.createVisitante("Daniel", "1031", "1021", 17, 1.67, 2500);

        assertTrue(resultado);
    }


    @Test
    @DisplayName("Metodo para la eliminacion de un visitante")
    public void deleteVisitante(){

        boolean resultado = parque.deleteVisitante("1031");
        assertTrue(resultado);
    }


    @Test
    @DisplayName("Metodo para la actualizacion de un visitante")
    public void updateVisitante(){

        boolean resultado = parque.updateVisitante("1031", "David", 65, 1.75);

        assertTrue(resultado);
    }




    @Test
    @DisplayName("Metodo para validar el registro de zonas y que se guarde correctamente en la lista del parque")
    public void validarListaZonas(){

        boolean resultado = admin.createZona("zona1", 100);
        assertTrue(resultado);

        ArrayList<Zona> resultado1 = parque.getListZonas();
        assertEquals(2, resultado1.size());
    }

    @Test
    @DisplayName("Metodo para validar que se este guardando correctamente la lista de operador")
    public void validarListaOperador() {

        ArrayList<Empleado> resultado = parque.getListEmpleados();
        assertEquals(2, resultado.size());
    }




  
}