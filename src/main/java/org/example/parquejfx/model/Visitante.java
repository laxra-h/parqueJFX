package org.example.parquejfx.model;

<<<<<<< HEAD
import java.util.ArrayList;

public class Visitante implements INotificable{
    private String nombre;
    private String cedula;
    private int edad;
    private double estatura;
    private float saldoVirtual;
    private boolean fotografia;
    private ArrayList<Atraccion> listFavoritas;
    private ArrayList<DetallesAtraccion> listDetalles;
    private Ticket theTicket;


    public Visitante(String nombre, String cedula, int edad, double estatura, float saldoVirtual) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.estatura = estatura;
        this.saldoVirtual = saldoVirtual;
        listFavoritas = new ArrayList<>();
        listDetalles = new ArrayList<>();
    }

    public void agregarAtraccionFavorita(String nombre){
        Atraccion atraccion = buscarAtraccion(nombre);
        if (atraccion != null) {
            listFavoritas.add(atraccion);
        }
    }

    public Atraccion buscarAtraccion(String nombre){
        for (int i = 0; i < listDetalles.size(); i++){
            Atraccion a =  listDetalles.get(i).getTheAtraccion();
            if (a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
=======
import java.time.LocalDate;
import java.util.ArrayList;

public class Visitante implements INotificable{
private String nombre;
private String cedula;
private String contrasenia;
private int edad;
private double estatura;
private float saldoVirtual;
private boolean fotografia;
private ArrayList<Atraccion> listFavoritas;
private ArrayList<DetallesAtraccion> listDetalles;
private Ticket theTicket;



public Visitante(String nombre, String cedula, String contrasenia, int edad, double estatura, float saldoVirtual) {
    this.nombre = nombre;
    this.cedula = cedula;
     this.contrasenia = contrasenia;
    this.edad = edad;
    this.estatura = estatura;
    this.saldoVirtual = 0;
    listFavoritas = new ArrayList<>();
    listDetalles = new ArrayList<>();
}

public void agregarAtraccionFavorita(String nombre){
    Atraccion atraccion = buscarAtraccion(nombre);
    if (atraccion != null) {
        listFavoritas.add(atraccion);
    }
}

public Atraccion buscarAtraccion(String nombre){
    for (int i = 0; i < listDetalles.size(); i++){
        Atraccion a =  listDetalles.get(i).getTheAtraccion();
        if (a.getNombre().equals(nombre)){
            return a;
        }
    }
    return null;
}

public boolean comprarGeneral() {
    if (saldoVirtual >= General.PRECIO) {
        saldoVirtual -= General.PRECIO;
        theTicket = new General(cedula, LocalDate.now());
        return true;
    }
    return false;
}

    public boolean comprarFamiliar(int descuento) {
        if (saldoVirtual >= Familiar.PRECIO) {
            saldoVirtual-=Familiar.PRECIO;
            theTicket = new Familiar(cedula, LocalDate.now(), descuento);
            return true;
        }
        return false;
    }

    public boolean comprarFastPass() {
        if (saldoVirtual >= FastPass.PRECIO) {
            saldoVirtual-=FastPass.PRECIO;
            theTicket = new FastPass(cedula, LocalDate.now());
            return true;
        }
        return false;
>>>>>>> dev_Daniel
    }









<<<<<<< HEAD

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public float getSaldoVirtual() {
        return saldoVirtual;
    }

    public void setSaldoVirtual(float saldoVirtual) {
        this.saldoVirtual = saldoVirtual;
    }

    public boolean isFotografia() {
        return fotografia;
    }

    public void setFotografia(boolean fotografia) {
        this.fotografia = fotografia;
    }

    public ArrayList<Atraccion> getListFavoritas() {
        return listFavoritas;
    }

    public void setListFavoritas(ArrayList<Atraccion> listFavoritas) {
        this.listFavoritas = listFavoritas;
    }

    public ArrayList<DetallesAtraccion> getListDetalles() {
        return listDetalles;
    }

    public void setListDetalles(ArrayList<DetallesAtraccion> listDetalles) {
        this.listDetalles = listDetalles;
    }

    public Ticket getTheTicket() {
        return theTicket;
    }

    public void setTheTicket(Ticket theTicket) {
        this.theTicket = theTicket;
=======
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getCedula() {
    return cedula;
}

public void setCedula(String cedula) {
    this.cedula = cedula;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public double getEstatura() {
    return estatura;
}

public void setEstatura(double estatura) {
    this.estatura = estatura;
}

public float getSaldoVirtual() {
    return saldoVirtual;
}

public void setSaldoVirtual(float saldoVirtual) {
    this.saldoVirtual = saldoVirtual;
}

public boolean isFotografia() {
    return fotografia;
}

public void setFotografia(boolean fotografia) {
    this.fotografia = fotografia;
}

public ArrayList<Atraccion> getListFavoritas() {
    return listFavoritas;
}

public void setListFavoritas(ArrayList<Atraccion> listFavoritas) {
    this.listFavoritas = listFavoritas;
}

public ArrayList<DetallesAtraccion> getListDetalles() {
    return listDetalles;
}

public void setListDetalles(ArrayList<DetallesAtraccion> listDetalles) {
    this.listDetalles = listDetalles;
}

public Ticket getTheTicket() {
    return theTicket;
}

public void setTheTicket(Ticket theTicket) {
    this.theTicket = theTicket;
}
public String getContrasenia() {
    return contrasenia;
}

    public void setContrasenia(String contrasenia){
        if (!contrasenia.isEmpty()) {
            this.contrasenia = contrasenia;
        }
>>>>>>> dev_Daniel
    }
}
