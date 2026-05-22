package org.example.parquejfx.model;

import java.util.ArrayList;

public class Administrador extends Empleado {


    private Parque parque;


    public Administrador(String nombre, String cedula, String contrasenia) {
        super(nombre, cedula, contrasenia);
        parque = null;
    }


    /*CRUD OPERADOR*/

    public boolean createOperador(String nombre, String cedula, String contrasenia, Zona zonaAsignada) {
        if (buscarOperador(cedula) != -1) {
            return false;
        }
        Operador newOperador = new Operador(nombre, cedula, contrasenia, zonaAsignada);
        parque.getListEmpleados().add(newOperador);
        return true;
    }

    public String readOperador(String cedula) {
        int posicion = buscarOperador(cedula);
        if (parque.getListEmpleados().get(posicion) instanceof Operador) {

            Operador o = (Operador) parque.getListEmpleados().get(posicion);

            return "Nombre: " + o.getNombre() + "\nCedula: " + o.getCedula() + "\nZona Asignada: " + o.getZonaAsignada();

        }

        return "El empleado no es un operador";


    }

    public boolean updateOperador(String nombre, String cedula, Zona zonaAsignada) {
        int posicion = buscarOperador(cedula);
        if (posicion != -1 && parque.getListEmpleados().get(posicion) instanceof Operador) {
            parque.getListEmpleados().get(posicion).setNombre(nombre);
            parque.getListEmpleados().get(posicion).setCedula(cedula);
            Operador o = (Operador) parque.getListEmpleados().get(posicion);
            o.setZonaAsignada(zonaAsignada);
            return true;
        }
        return false;
    }

    public int buscarOperador(String cedulaBuscar) {
        for (int i = 0; i < parque.getListEmpleados().size(); i++) {
            if (parque.getListEmpleados().get(i).getCedula().equals(cedulaBuscar)) {
                return i;
            }
        }

        return -1;
    }

    public boolean deleteOperador(String cedula) {
        int posicion = buscarOperador(cedula);
        if (posicion != -1) {
            parque.getListEmpleados().remove(posicion);
            return true;
        }
        return false;
    }

    /*CRUD ATRACCION*/

    public boolean createAtraccion(String codigo, String nombre, int capacidadMaxima, double estaturaMinima, int edadMinima, double costoAdicional, int descuento, int contadorVisitantes, int tiempoEspera, EstadoAtraccion estado, TipoAtraccion tipo, MotivoCierre motivoCierre) {
        if (buscarAtraccion(codigo) != -1) {
            return false;
        }
        Atraccion newAtraccion = new Atraccion(codigo, nombre, capacidadMaxima, estaturaMinima, edadMinima, costoAdicional, descuento, contadorVisitantes, tiempoEspera, estado, tipo, motivoCierre);
        parque.getListAtracciones().add(newAtraccion);
        return true;
    }

    public String readAtraccion(String codigo) {
        int posicion = buscarAtraccion(codigo);
        Atraccion a = parque.getListAtracciones().get(posicion);
        return "Nombre: " + a.getNombre() + "\nCapacidadMax: " + a.getCapacidadMaxima() + "\nEstatura minima: " + a.getEstaturaMinima() + "\nEdad minima: " + a.getEdadMinima() + "\nCosto adicional: " + a.getCostoAdicional() + "\nContador de visitantes: " + a.getContadorVisitantes() + "\nTiempo de espera: " + a.getTiempoEspera() + "\nEstado: " + a.getEstado() + "\nTipo: " + a.getTipo() + "\nMotivo Cierre: " + a.getMotivoCierre();
    }

    public boolean updateAtraccion(String codigo, String nombre, int capacidadMaxima, double estaturaMinima, int edadMinima, double costoAdicional, int descuento, int contadorVisitantes, int tiempoEspera, EstadoAtraccion estado, TipoAtraccion tipo, MotivoCierre motivoCierre) {
        int posicion = buscarAtraccion(cedula);
        if (posicion != -1) {
            parque.getListAtracciones().get(posicion).setCodigo(codigo);
            parque.getListAtracciones().get(posicion).setNombre(nombre);
            parque.getListAtracciones().get(posicion).setCapacidadMaxima(capacidadMaxima);
            parque.getListAtracciones().get(posicion).setEstaturaMinima(estaturaMinima);
            parque.getListAtracciones().get(posicion).setEdadMinima(edadMinima);
            parque.getListAtracciones().get(posicion).setCostoAdicional(costoAdicional);
            parque.getListAtracciones().get(posicion).setDescuento(descuento);
            parque.getListAtracciones().get(posicion).setContadorVisitantes(contadorVisitantes);
            parque.getListAtracciones().get(posicion).setTiempoEspera(tiempoEspera);
            parque.getListAtracciones().get(posicion).setEstado(estado);
            parque.getListAtracciones().get(posicion).setTipo(tipo);
            parque.getListAtracciones().get(posicion).setMotivoCierre(motivoCierre);
            return true;
        }
        return false;
    }

    public int buscarAtraccion(String codigoBuscar) {
        for (int i = 0; i < parque.getListAtracciones().size(); i++) {
            if (parque.getListAtracciones().get(i).getCodigo().equals(codigoBuscar)) {
                return i;
            }
        }

        return -1;
    }

    public boolean deleteAtraccion(String codigo) {
        int posicion = buscarAtraccion(codigo);
        if (posicion != -1) {
            parque.getListAtracciones().remove(posicion);
            return true;
        }
        return false;
    }

    /*CRUD ZONA*/

    public boolean createZona(String nombre, int capacidadMaxima) {
        if (buscarZona(nombre) != -1) {
            return false;
        }
        Zona newZona = new Zona(nombre, capacidadMaxima);
        parque.getListZonas().add(newZona);
        return true;
    }

    public String readZona(String nombre) {
        int posicion = buscarZona(nombre);
        Zona z = parque.getListZonas().get(posicion);
        String operadores = "";
        for (Operador o : z.getListOperadores()) {
            operadores += o.getNombre() + "\n";
        }
        return "Nombre: " + z.getNombre() + "\nCapacidadMax: " + z.getCapacidadMaxima() + "\nOperadores de la zona: \n" + operadores;
    }

    public boolean updateZona(String nombre, int capacidadMaxima) {
        int posicion = buscarZona(nombre);
        if (posicion != -1) {
            parque.getListZonas().get(posicion).setNombre(nombre);
            parque.getListZonas().get(posicion).setCapacidadMaxima(capacidadMaxima);
            parque.getListAtracciones().get(posicion).setCapacidadMaxima(capacidadMaxima);

            return true;
        }
        return false;
    }

    public int buscarZona(String nombreBuscar) {
        for (int i = 0; i < parque.getListZonas().size(); i++) {
            if (parque.getListZonas().get(i).getNombre().equals(nombreBuscar)) {
                return i;
            }
        }

        return -1;
    }

    public boolean deleteZona(String nombre) {
        int posicion = buscarZona(nombre);
        if (posicion != -1) {
            parque.getListZonas().remove(posicion);
            return true;
        }
        return false;
    }


    //ACTIVAR Y DESACTIVAR ALARMA
    public boolean activarAlarmaCLimatica() {
        for (Atraccion a : parque.getListAtracciones()) {
            if ((a.getTipo().equals(TipoAtraccion.ACUATICA) || a.getTipo().equals(TipoAtraccion.MECANICA_DE_ALTURA)) && a.getEstado() != EstadoAtraccion.EN_MANTENIMIENTO) {
                a.setEstado(EstadoAtraccion.CERRADA);
            }
        }
        return true;
    }

    public boolean desactivarAlarmaClimatica() {
        for (Atraccion a : parque.getListAtracciones()) {
            if ((a.getTipo() == (TipoAtraccion.ACUATICA) || a.getTipo() == (TipoAtraccion.MECANICA_DE_ALTURA)) && a.getEstado() != EstadoAtraccion.EN_MANTENIMIENTO) {
                a.setEstado(EstadoAtraccion.ACTIVA);
            }
        }
        return true;
    }

    //ASIGNAR OPERADOR
    public boolean asignarOperador(String cedulaOperador, String nombreZona) {
        int posicionOperador = buscarOperador(cedulaOperador);
        int posicionZona = buscarZona(nombreZona);

        if (posicionZona != -1 && posicionOperador != -1) {
            Empleado emp = parque.getListEmpleados().get(posicionOperador);
            if (emp instanceof Operador) {
                Operador op = (Operador) emp;
                if (op.getZonaAsignada() == null) {
                    Zona z = parque.getListZonas().get(posicionZona);
                    op.setZonaAsignada(z);
                    return true;
                }
            }
        }
        return false;
    }

    //MOSTRAR ATRACCIONES SIN OPERADOR ASIGNADO
    public String mostrarAtraccionesSinOperador() {
        String resultado = "";
        for (Atraccion a : parque.getListAtracciones()) {
            if (a.getTheOperador() == null) {
                resultado += a.getNombre() + "\n";
            }
        }
        return resultado;
    }

    //CONSULTAR REPORTES
    //public String consultarReportes() {













    //GETTERS && SETTERS


    public Parque getParque() {
        return parque;
    }

    public void setParque(Parque parque) {
        this.parque = parque;
    }
}
