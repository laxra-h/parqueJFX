package org.example.parquejfx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.example.parquejfx.App;
import org.example.parquejfx.controller.OperadorController;
import org.example.parquejfx.model.*;
import org.example.parquejfx.util.SceneManager;
import java.util.ArrayList;

public class OperadorController {
    private Parque parque;
    private Operador operador;

    public OperadorController(Parque parque) {
        this.parque = parque;
    }

    public boolean ingresarOperador(TextField cedula, TextField contrasenia) {
        boolean ok = parque.verificarIngresoOperador(cedula.getText(), contrasenia.getText());
        if (ok) {
            for (Empleado e : parque.getListEmpleados()) {
                if (e.getCedula().equals(cedula) && e instanceof Operador) {
                    this.operador = (Operador) e;
                    break;
                }
            }
        }
        return ok;
    }

    public Operador getOperador() { return operador; }
    public void setOperador(Operador operador) { this.operador = operador; }
    public Parque getParque() { return parque; }

    public String getNombreOperador() {
        return operador != null ? operador.getNombre() : "—";
    }

    public Atraccion getAtraccionAsignada() {
        if (operador == null || operador.getZonaAsignada() == null) return null;
        Zona zona = operador.getZonaAsignada();
        if (zona.getListAtracciones() != null && !zona.getListAtracciones().isEmpty()) {
            return zona.getListAtracciones().get(0);
        }
        return null;
    }

    public String getNombreAtraccion() {
        Atraccion a = getAtraccionAsignada();
        return a != null ? a.getNombre() : "Sin atracción asignada";
    }

    public String getEstaturaMinima() {
        Atraccion a = getAtraccionAsignada();
        return a != null ? a.getEstaturaMinima() + " m" : "—";
    }

    public String getTiempoEspera() {
        Atraccion a = getAtraccionAsignada();
        return a != null ? a.getTiempoEspera() + " min" : "—";
    }

    public int getVisitantesAcumulados() {
        Atraccion a = getAtraccionAsignada();
        return a != null ? a.getContadorVisitantes() : 0;
    }

    // ── Ingreso de visitante ──────────────────────────────────────

    public boolean visitanteExiste(String cedula) {
        return parque.buscarVisitanteByCedula(cedula) != null;
    }

    public boolean verificarAccesoVisitante(String cedula) {
        Visitante visitante = parque.buscarVisitanteByCedula(cedula);
        if (visitante == null) return false;

        Atraccion atraccion = getAtraccionAsignada();
        if (atraccion == null) return false;

        DetallesAtraccion detalle = new DetallesAtraccion(visitante, atraccion);
        return detalle.verificarAcceso();
    }

    // ── Recarga de saldo ─────────────────────────────────────────

    public boolean recargarSaldo(String cedula, float monto) {
        Visitante visitante = parque.buscarVisitanteByCedula(cedula);
        if (visitante == null) return false;
        visitante.setSaldoVirtual(visitante.getSaldoVirtual() + monto);
        return true;
    }

    // ── Gestión de atracciones ───────────────────────────────────

    public ArrayList<Atraccion> getAtraccionesZona() {
        if (operador == null || operador.getZonaAsignada() == null) return new ArrayList<>();
        return operador.getZonaAsignada().getListAtracciones();
    }

    public boolean cambiarEstadoAtraccion(String nombreAtraccion, EstadoAtraccion nuevoEstado) {
        for (Atraccion a : getAtraccionesZona()) {
            if (a.getNombre().equals(nombreAtraccion)) {
                a.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }
}