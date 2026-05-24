package org.example.parquejfx.model;

public enum EstadoAtraccion {
    ACTIVA,
    EN_MANTENIMIENTO,
<<<<<<< HEAD
    CERRADA
=======
    CERRADA;
>>>>>>> dev_Daniel

    @Override
    public String toString() {
        return switch (this) {
            case ACTIVA -> "Activa";
            case EN_MANTENIMIENTO -> "Mantenimiento";
            case CERRADA -> "Cerrada";
        };
    }
}
