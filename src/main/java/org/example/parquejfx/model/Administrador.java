package org.example.parquejfx.model;

import java.util.ArrayList;

public class Administrador extends Empleado{

    ArrayList<Operador> listOperadores;

    public Administrador(String nombre, String cedula) {
        super(nombre, cedula);
        listOperadores = new ArrayList<>();
    }


    /*CRUD OPERADOR*/

    public boolean createOperador(String nombre, String cedula, String zonaAsignada){
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

    public boolean updateOperador(String nombre, String cedula, String zonaAsignada){
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
    public boolean createOperador(String nombre, String cedula, String zonaAsignada){
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

    public boolean updateOperador(String nombre, String cedula, String zonaAsignada){
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





}
