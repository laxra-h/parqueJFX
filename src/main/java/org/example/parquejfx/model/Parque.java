package org.example.parquejfx.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumMap;

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


    public boolean createVisitante(String nombre, String cedula, int edad, double estatura, float saldoVirtual){

        Visitante newVisitante = new Visitante(nombre, cedula, edad, estatura, saldoVirtual);

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

//CRUD ADMIN


    public boolean createAdmin(String nombre, String cedula, String contrasenia){

        Administrador newAdmin = new Administrador(nombre, cedula, contrasenia);
        for(Empleado e: listEmpleados){
            if(e.getCedula().equals(cedula)){
                return false;
            }
        }

        listEmpleados.add(newAdmin);
        return true;

    }

    public boolean deleteAdmin(String cedula){

        Administrador admin = buscarAdminByCedula(cedula);

        if(admin != null){
            listEmpleados.remove(admin);
            return true;
        }
        return false;
    }

    public boolean updateAdmin(String cedula, String nombreNuevo, String contraseniaNueva){

        Administrador admin = buscarAdminByCedula(cedula);

        if(admin != null){
            admin.setNombre(nombreNuevo);
            admin.setContrasenia(contraseniaNueva);
            return true;
        }

        return false;
    }


    public String readAdmin(String cedula){

        Administrador admin = buscarAdminByCedula(cedula);

        if(admin != null){

            return "Nombre: "+admin.getNombre()+
                    " | cedula: "+admin.getCedula()+
                    " | Contrasenia: " +admin.getContrasenia();
        }
        return "Administrador no encontrado";
    }

    public Administrador buscarAdminByCedula(String cedula){
        for(Empleado e: listEmpleados){
            if(e instanceof  Administrador && e.getCedula().equals(cedula)){
                return (Administrador) e;
            }
        }
        return null;
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

    public ArrayList<Atraccion> getListAtracciones() {
        return listAtracciones;
    }

    public void setListAtracciones(ArrayList<Atraccion> listAtracciones) {
        this.listAtracciones = listAtracciones;
    }
}
