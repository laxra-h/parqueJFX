package org.example.parquejfx.model;

import java.util.ArrayList;

public class Administrador extends Empleado{

    ArrayList<Operador> listOperadores;
    ArrayList<Zona> listZonas;
    ArrayList<Atraccion> listAtracciones;

    public Administrador(String nombre, String cedula) {
        super(nombre, cedula);
        listOperadores = new ArrayList<>();
        listZonas = new ArrayList<>();
        listAtracciones = new ArrayList<>();
    }


    /*CRUD OPERADOR*/

    public boolean createOperador(String nombre, String cedula, Zona zonaAsignada){
        if (buscarOperador(cedula) != -1){
            return false;
        }
        Operador newOperador = new Operador(nombre, cedula, zonaAsignada);
        listOperadores.add(newOperador);
        return true;
    }

    public String readOperador(String cedula){
        int posicion =  buscarOperador(cedula);
        Operador o = listOperadores.get(posicion);
        return "Nombre: "+ o.getNombre() + "\nCedula: "+ o.getCedula() + "\nZona Asignada: "+ o.getZonaAsignada();
    }

    public boolean updateOperador(String nombre, String cedula, Zona zonaAsignada){
        int posicion = buscarOperador(cedula);
        if (posicion != -1) {
            listOperadores.get(posicion).setNombre(nombre);
            listOperadores.get(posicion).setCedula(cedula);
            listOperadores.get(posicion).setZonaAsignada(zonaAsignada);
            return true;
        }
        return false;
    }

    public int buscarOperador(String cedulaBuscar){
        for (int i = 0; i < listOperadores.size(); i++) {
            if (listOperadores.get(i).getCedula().equals(cedulaBuscar)){
                return i;
            }
        }

        return -1;
    }

    public boolean deleteOperador(String cedula){
        int posicion = buscarOperador(cedula);
        if (posicion != -1) {
            listOperadores.remove(posicion);
            return true;
        }
        return false;
    }

    /*CRUD ATRACCION*/

    public boolean createAtraccion(String codigo, String nombre, int capacidadMaxima, double estaturaMinima, int edadMinima, double costoAdicional, int descuento, int contadorVisitantes, int tiempoEspera, EstadoAtraccion estado, TipoAtraccion tipo, MotivoCierre motivoCierre){
        if (buscarAtraccion(codigo) != -1){
            return false;
        }
        Atraccion newAtraccion = new Atraccion(codigo, nombre, capacidadMaxima, estaturaMinima, edadMinima, costoAdicional, descuento, contadorVisitantes, tiempoEspera, estado, tipo, motivoCierre);
        listAtracciones.add(newAtraccion);
        return true;
    }

    public String readAtraccion(String codigo){
        int posicion =  buscarAtraccion(codigo);
        Atraccion a = listAtracciones.get(posicion);
        return "Nombre: "+ a.getNombre() + "\nCapacidadMax: "+ a.getCapacidadMaxima() + "\nEstatura minima: "+ a.getEstaturaMinima() + "\nEdad minima: " + a.getEdadMinima() + "\nCosto adicional: " + a.getCostoAdicional() + "\nContador de visitantes: " + a.getContadorVisitantes() + "\nTiempo de espera: " + a.getTiempoEspera() + "\nEstado: " + a.getEstado() + "\nTipo: " + a.getTipo() + "\nMotivo Cierre: " + a.getMotivoCierre();
    }

    public boolean updateAtraccion(String codigo, String nombre, int capacidadMaxima, double estaturaMinima, int edadMinima, double costoAdicional, int descuento, int contadorVisitantes, int tiempoEspera, EstadoAtraccion estado, TipoAtraccion tipo, MotivoCierre motivoCierre){
        int posicion = buscarAtraccion(cedula);
        if (posicion != -1) {
            listAtracciones.get(posicion).setCodigo(codigo);
            listAtracciones.get(posicion).setNombre(nombre);
            listAtracciones.get(posicion).setCapacidadMaxima(capacidadMaxima);
            listAtracciones.get(posicion).setEstaturaMinima(estaturaMinima);
            listAtracciones.get(posicion).setEdadMinima(edadMinima);
            listAtracciones.get(posicion).setCostoAdicional(costoAdicional);
            listAtracciones.get(posicion).setDescuento(descuento);
            listAtracciones.get(posicion).setContadorVisitantes(contadorVisitantes);
            listAtracciones.get(posicion).setTiempoEspera(tiempoEspera);
            listAtracciones.get(posicion).setEstado(estado);
            listAtracciones.get(posicion).setTipo(tipo);
            listAtracciones.get(posicion).setMotivoCierre(motivoCierre);
            return true;
        }
        return false;
    }

    public int buscarAtraccion(String codigoBuscar){
        for (int i = 0; i < listAtracciones.size(); i++) {
            if (listAtracciones.get(i).getCodigo().equals(codigoBuscar)){
                return i;
            }
        }

        return -1;
    }

    public boolean deleteAtraccion(String codigo){
        int posicion = buscarAtraccion(codigo);
        if (posicion != -1) {
            listAtracciones.remove(posicion);
            return true;
        }
        return false;
    }

    /*CRUD ZONA*/

    public boolean createZona(String nombre, int capacidadMaxima){
        if (buscarZona(nombre) != -1){
            return false;
        }
        Zona newZona = new Zona(nombre, capacidadMaxima);
        listZonas.add(newZona);
        return true;
    }

    public String readZona(String nombre){
        int posicion =  buscarZona(nombre);
        Zona z = listZonas.get(posicion);
        String operadores = "";
        for (Operador o : z.getListOperadores()){
            operadores += o.getNombre() + "\n";
        }
        return "Nombre: "+ z.getNombre() + "\nCapacidadMax: "+ z.getCapacidadMaxima() + "\nOperadores de la zona: \n" + operadores;
    }

    public boolean updateZona(String nombre, int capacidadMaxima){
        int posicion = buscarZona(nombre);
        if (posicion != -1) {
            listZonas.get(posicion).setNombre(nombre);
            listZonas.get(posicion).setCapacidadMaxima(capacidadMaxima);
            listAtracciones.get(posicion).setCapacidadMaxima(capacidadMaxima);

            return true;
        }
        return false;
    }

    public int buscarZona(String nombreBuscar){
        for (int i = 0; i < listZonas.size(); i++) {
            if (listZonas.get(i).getNombre().equals(nombreBuscar)){
                return i;
            }
        }

        return -1;
    }

    public boolean deleteZona(String nombre){
        int posicion = buscarZona(nombre);
        if (posicion != -1) {
            listZonas.remove(posicion);
            return true;
        }
        return false;
    }


    //ACTIVAR Y DESACTIVAR ALARMA
    public boolean activarAlarmaCLimatica() {
            for (Atraccion a : listAtracciones) {
                if ((a.getTipo().equals(TipoAtraccion.ACUATICA) || a.getTipo().equals(TipoAtraccion.MECANICA_DE_ALTURA)) && a.getEstado() != EstadoAtraccion.EN_MANTENIMIENTO){
                    a.setEstado(EstadoAtraccion.CERRADA);
                }
            }
            return true;
    }
    public boolean desactivarAlarmaClimatica () {
        for (Atraccion a : listAtracciones) {
            if ((a.getTipo() == (TipoAtraccion.ACUATICA) || a.getTipo() == (TipoAtraccion.MECANICA_DE_ALTURA)) && a.getEstado() != EstadoAtraccion.EN_MANTENIMIENTO){
                a.setEstado(EstadoAtraccion.ACTIVA);
            }
        }
        return true;
    }

    //ASIGNAR OPERADOR
    public boolean asignarOperador(String cedulaOperador, String nombreZona) {
        int posicionOperador = buscarOperador(cedulaOperador);
        int posicionZona = buscarZona(nombreZona);
        if (posicionZona != -1 && posicionOperador != -1 && listOperadores.get(posicionOperador).getZonaAsignada() == null) {
            Zona z = listZonas.get(posicionZona);
            listOperadores.get(posicionOperador).setZonaAsignada(z);
            return true;
        }
        return false;
    }

    //MOSTRAR ATRACCIONES SIN OPERADOR ASIGNADO
    public String mostrarAtraccionesSinOperador() {
       String resultado = "";
        for (Atraccion a : listAtracciones) {
            if (a.getTheOperador() == null){
                resultado += a.getNombre() + "\n";
            }
        }
        return resultado;
    }

    //CONSULTAR REPORTES
    public String consultarReportes() {


    }









    //GETTERS && SETTERS

    public ArrayList<Operador> getListOperadores() {
        return listOperadores;
    }

    public void setListOperadores(ArrayList<Operador> listOperadores) {
        this.listOperadores = listOperadores;
    }

    public ArrayList<Zona> getListZonas() {
        return listZonas;
    }

    public void setListZonas(ArrayList<Zona> listZonas) {
        this.listZonas = listZonas;
    }

    public ArrayList<Atraccion> getListAtracciones() {
        return listAtracciones;
    }

    public void setListAtracciones(ArrayList<Atraccion> listAtracciones) {
        this.listAtracciones = listAtracciones;
    }
}
