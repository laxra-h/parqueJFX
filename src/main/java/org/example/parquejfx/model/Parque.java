package org.example.parquejfx.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Parque {
    private String nit;
    private String nombre;
    private String direccion;
    private int aforoMaximo;
    private ArrayList<Empleado> listEmpleados;
    private ArrayList<Zona> listZonas;
    private ArrayList<Visitante> listVisitantes;
    private ArrayList<Atraccion> listAtracciones;
    private Mapa theMapa;
    private ArrayList<Notificacion> listNotificaciones;
    private ArrayList<Ticket> listTickets;


    public Parque(String nit, String nombre, String direccion, int aforoMaximo) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforoMaximo = aforoMaximo;
        listEmpleados = new ArrayList<>();
        listZonas = new ArrayList<>();
        listVisitantes = new ArrayList<>();
        listNotificaciones = new ArrayList<>();
        listTickets = new ArrayList<>();
        listAtracciones = new ArrayList<>();
    }


    public ArrayList<Visitante> listDiaria(LocalDate fechaDia) {
        ArrayList<Visitante> resultado = new ArrayList<>();
        for (Visitante v : listVisitantes){
            if (v.getTheTicket().getFechaCompra() == fechaDia){
                resultado.add(v);
            }
        }
        return resultado;
    }


    public float calcularIngresosDiarios(LocalDate fechaDia) {
        float boletosDiarios = 0;
        float costosAdicionales = 0;
        for (Visitante v : listDiaria(fechaDia)) {
            boletosDiarios += v.getTheTicket().getPrecio();
        }
        for (Atraccion a : listAtracciones) {
            ArrayList<DetallesAtraccion> listDetalles = a.getListDetalles();
            for (DetallesAtraccion d : listDetalles) {

            }
            }
        return costosAdicionales;

    }


    //CRUD VISITANTE


    public boolean createVisitante(String nombre, String cedula, int edad, double estatura, float saldoVirtual, boolean fotografia){

        Visitante newVisitante = new Visitante(nombre, cedula, edad, estatura, saldoVirtual, fotografia);

        for(Visitante v: listVisitantes) {
            if (v.getCedula().equals(cedula)){
                return false;
            }
        }
        listVisitantes.add(newVisitante);
        return true;
    }


    public boolean deleteVisitante(String cedula){

        Visitante visitante = buscarVisitanteByCedula(cedula);

        if(visitante != null){
            listVisitantes.remove(visitante);
            return true;
        }
        return false;
    }



    //metodo para actualizar visitante


    public boolean updateVisitante(String cedula, String nombreNuevo, int edadNueva, double estaturaNueva  ){
        Visitante visitante = buscarVisitanteByCedula(cedula);

        if(visitante != null){
            visitante.setNombre(nombreNuevo);
            visitante.setEdad(edadNueva);
            visitante.setEstatura(estaturaNueva);
            return true;
        }

        return false;
    }


//Metodo para buscar visitante

public Visitante buscarVisitanteByCedula(String cedula) {
        for(Visitante v: listVisitantes){
            if(v.getCedula().equals(cedula)){
                return v;
            }
        }

        return null;
}

//CRUD OPERADOR

    public boolean createOperador(Operador operador){

        if(operador == null){
            return false;
        }

        for(Operador o: listOperadores){
            if(o.getCedula().equals(operador.getCedula())){
                return false;
            }
        }

        listEmpleados.add(operador);
        return true;
    }


    public boolean deleteOperador(String codigo){

        Empleado operador = buscarOperador(codigo);

        if(operador != null){
            listEmpleados.remove(operador);
            return true;
        }

        return false;

    }












    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public ArrayList<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(ArrayList<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    public ArrayList<Zona> getListZonas() {
        return listZonas;
    }

    public void setListZonas(ArrayList<Zona> listZonas) {
        this.listZonas = listZonas;
    }

    public ArrayList<Visitante> getListVisitantes() {
        return listVisitantes;
    }

    public void setListVisitantes(ArrayList<Visitante> listVisitantes) {
        this.listVisitantes = listVisitantes;
    }

    public Mapa getTheMapa() {
        return theMapa;
    }

    public void setTheMapa(Mapa theMapa) {
        this.theMapa = theMapa;
    }

    public ArrayList<Notificacion> getListNotificaciones() {
        return listNotificaciones;
    }

    public void setListNotificaciones(ArrayList<Notificacion> listNotificaciones) {
        this.listNotificaciones = listNotificaciones;
    }

    public ArrayList<Ticket> getListTickets() {
        return listTickets;
    }

    public void setListTickets(ArrayList<Ticket> listTickets) {
        this.listTickets = listTickets;
    }
}
