package org.example.parquejfx.controller;

import javafx.scene.control.TextField;
import org.example.parquejfx.model.*;

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

    }


