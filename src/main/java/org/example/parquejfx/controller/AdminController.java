package org.example.parquejfx.controller;

import org.example.parquejfx.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdminController {
    private Parque parque;
    private Administrador administrador;

    public AdminController(Parque parque) {
        this.parque = parque;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean ingresar(String cedula, String contrasenia) {
        boolean ok = parque.verificarIngresoAdmin(cedula, contrasenia);
        if (ok) {
            // Busca y guarda el admin autenticado
            for (Empleado e : parque.getListEmpleados()) {
                if (e.getCedula().equals(cedula) && e instanceof Administrador) {
                    this.administrador = (Administrador) e;
                    administrador.setParque(parque);
                    break;
                }
            }
        }
        return ok;
    }

    // Zonas — delega al modelo
    public ArrayList<Zona> getZonas() {
        return parque.getListZonas();
    }

    public boolean agregarZona(String nombre, int capacidad) {
        return administrador.createZona(nombre, capacidad);
    }

    public boolean actualizarZona(String nombre, int capacidadMaxima) {
        return administrador.updateZona(nombre, capacidadMaxima);
    }

    public boolean eliminarZona(String nombre) {
        return administrador.deleteZona(nombre);
    }

    public boolean agregarOperador(String nombre, String cedula, String contrasenia) {
        return administrador.createOperador(nombre, cedula, contrasenia, null);
    }

    public boolean agregarAdministrador(String nombre, String cedula, String contrasenia) {

     return    parque.createAdmin(nombre, cedula, contrasenia);
    }

    public boolean eliminarEmpleado(String cedula) {
        return administrador.deleteOperador(cedula);
    }

    public ArrayList<Empleado> getEmpleados() {
        return parque.getListEmpleados();
    }
    public ArrayList<Operador> getOperadores() {
return parque.getOperadores();
    }

    public boolean asignarOperador(String cedulaOperador, String nombreZona) {
        return administrador.asignarOperador(cedulaOperador, nombreZona);
    }

    public boolean desasignarOperador(String cedulaOperador) {
        return desasignarOperador(cedulaOperador);
    }
    public ArrayList<Atraccion> getAtracciones() {
        return parque.getListAtracciones();
    }

    public boolean agregarAtraccion(String codigo, String nombre, int capacidad,
                                    double estatura, int edad, double costo, TipoAtraccion tipo) {
        return administrador.createAtraccion(codigo, nombre, capacidad, estatura, edad, costo, 0, 0, 0, EstadoAtraccion.ACTIVA, tipo, MotivoCierre.CLIMA);
    }

    public boolean eliminarAtraccion(String codigo) {
        return administrador.deleteAtraccion(codigo);
    }
    public boolean isAlertaActiva() {
        return administrador != null && administrador.isAlertaActiva();
    }
    public boolean activarAlerta() {
        if (administrador == null) {
            System.out.println("ERROR: administrador es null");
            return false;
        }
        return administrador.activarAlarmaCLimatica();
    }

    public boolean desactivarAlerta() {
        if (administrador == null) {
            System.out.println("ERROR: administrador es null");
            return false;
        }
        return administrador.desactivarAlarmaClimatica();
    }
    /*public int contarVisitantes (LocalDate fecha) {
        return parque.contarVisitantesDia(fecha);
    }
*/
    public Parque getParque() {
        return parque;
    }

    // ── Reportes globales (datos del parque) ──────────────────────────
    public int getTotalAtracciones() {
        return parque.getListAtracciones().size();
    }

    public int getTotalOperadores() {
        return parque.getOperadores().size();
    }

    public int getTotalVisitantes() {
        return parque.getListVisitantes().size();
    }

    // ── Reportes diarios (tickets e ingresos de HOY) ──────────────────
    public int getTicketsHoy() {
        LocalDate hoy = LocalDate.now();
        int count = 0;
        for (Ticket t : parque.getListTickets()) {
            if (t.getFechaCompra() != null && t.getFechaCompra().equals(hoy)) {
                count++;
            }
        }
        return count;
    }

    public float getIngresosHoy() {
        LocalDate hoy = LocalDate.now();
        float total = 0;
        for (Ticket t : parque.getListTickets()) {
            if (t.getFechaCompra() != null && t.getFechaCompra().equals(hoy)) {
                total += t.getPrecio();
            }
        }
        return total;
    }

    public int getAlertasActivas() {
        return isAlertaActiva() ? 1 : 0;
    }
}