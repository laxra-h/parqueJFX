package org.example.parquejfx.model;

import java.util.ArrayList;

public class Atraccion implements Iclosable{
private String codigo;
private String nombre;
private int capacidadMaxima;
private double estaturaMinima;
private int edadMinima;
private double costoAdicional;
private int contadorVisitantes = 0;
private int tiempoEspera;
private EstadoAtraccion estado;
private TipoAtraccion tipo;
private MotivoCierre motivoCierre;

private Operador theOperador;
private ArrayList<DetallesAtraccion> listDetalles;


    public Atraccion(String codigo, String nombre, int capacidadMaxima, double estaturaMinima, int edadMinima, double costoAdicional, int contadorVisitantes, int tiempoEspera, EstadoAtraccion estado, TipoAtraccion tipo, MotivoCierre motivoCierre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.estaturaMinima = estaturaMinima;
        this.edadMinima = edadMinima;
        this.costoAdicional = costoAdicional;
        this.contadorVisitantes = contadorVisitantes;
        this.tiempoEspera = tiempoEspera;
        this.estado = estado;
        this.tipo = tipo;
        this.motivoCierre = motivoCierre;
        listDetalles = new ArrayList<>();
    }

    @Override
 public void cerrarAtraccionMantenimiento(){
      for (DetallesAtraccion d : listDetalles) {
          if (d.verificarAcceso()){
              contadorVisitantes++;
          }
      }
      if (contadorVisitantes == 500){
          estado = EstadoAtraccion.CERRADA;

      }

}

















    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getEstaturaMinima() {
        return estaturaMinima;
    }

    public void setEstaturaMinima(double estaturaMinima) {
        this.estaturaMinima = estaturaMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public int getContadorVisitantes() {
        return contadorVisitantes;
    }

    public void setContadorVisitantes(int contadorVisitantes) {
        this.contadorVisitantes = contadorVisitantes;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public EstadoAtraccion getEstado() {
        return estado;
    }

    public void setEstado(EstadoAtraccion estado) {
        this.estado = estado;
    }

    public TipoAtraccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtraccion tipo) {
        this.tipo = tipo;
    }

    public MotivoCierre getMotivoCierre() {
        return motivoCierre;
    }

    public void setMotivoCierre(MotivoCierre motivoCierre) {
        this.motivoCierre = motivoCierre;
    }

    public Operador getTheOperador() {
        return theOperador;
    }

    public void setTheOperador(Operador theOperador) {
        this.theOperador = theOperador;
    }

    public ArrayList<DetallesAtraccion> getListDetalles() {
        return listDetalles;
    }

    public void setListDetalles(ArrayList<DetallesAtraccion> listDetalles) {
        this.listDetalles = listDetalles;
    }
}
