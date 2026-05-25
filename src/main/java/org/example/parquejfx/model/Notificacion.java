package org.example.parquejfx.model;

public record Notificacion(String mensaje, MotivoCierre motivo, Atraccion theAtraccion) {


    //GENERAR NOTIFICACION
    public String generarNotificacion() {
        if (theAtraccion.getMotivoCierre() == MotivoCierre.MANTENIMIENTO) {
            return "La atraccion " + theAtraccion.getNombre() + " se encuentra temporalmente cerrada por motivos de mantenimiento.";
        } else if (theAtraccion.getMotivoCierre() == MotivoCierre.CLIMA) {
            return "La atraccion " + theAtraccion.getNombre() + " se encuentra temporalmente cerrada por motivos climaticos.\n¡Gracias por su comprensión, que disfrute de su estadia!.";
        }else if(motivo == MotivoCierre.CLIMA && theAtraccion == null ){
            return "Se les informa que las atracciones mecanicas y acuaticas están cerradas por la causa climatica que se está presentando";
        }else {
    return "";
        }
    }







}
