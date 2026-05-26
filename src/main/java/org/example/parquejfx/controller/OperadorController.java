package org.example.parquejfx.controller;

import javafx.scene.control.TextField;
import org.example.parquejfx.model.*;

import java.util.ArrayList;

public class OperadorController {
        private Parque parque;
        private Operador operador;

        public OperadorController(Parque parque) {
            this.parque = parque;
        }

        public boolean ingresarOperador(String cedula, String contrasenia) {
            boolean ok = parque.verificarIngresoOperador(cedula, contrasenia);
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

        public Operador getOperador() {
            return operador;
        }

        public void setOperador(Operador operador) {
            this.operador = operador;
        }

        public String getNombreOperador() {
            return operador != null ? operador.getNombre() : "—";
        }

        public Atraccion getAtraccionAsignada() {
            if (operador == null || operador.getZonaAsignada() == null) return null;
            // Retorna la primera atracción de la zona asignada
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
            return a != null ? String.valueOf(a.getEstaturaMinima()) + " m" : "—";
        }

        public String getTiempoEspera() {
            Atraccion a = getAtraccionAsignada();
            return a != null ? a.getTiempoEspera() + " min" : "—";
        }

        public int getVisitantesAcumulados() {
            Atraccion a = getAtraccionAsignada();
            return a != null ? a.getContadorVisitantes() : 0;
        }

        public Parque getParque() {
            return parque;
        }

    public boolean verificarAccesoVisitante(String cedula) {
        Visitante visitante = parque.buscarVisitanteByCedula(cedula);
        if (visitante == null) return false;

        Atraccion atraccion = getAtraccionAsignada();
        if (atraccion == null) return false;

        DetallesAtraccion detalle = new DetallesAtraccion(atraccion, visitante);
        return detalle.verificarAcceso();
    }

    public boolean visitanteExiste(String cedula) {
        return parque.buscarVisitanteByCedula(cedula) != null;
    }
    public boolean recargarSaldo(String cedula, float monto) {
        Visitante visitante = parque.buscarVisitanteByCedula(cedula);
        if (visitante == null) return false;
        visitante.setSaldoVirtual(visitante.getSaldoVirtual() + monto);
        return true;
    }
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


