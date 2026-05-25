package org.example.parquejfx.model;

public enum TipoAtraccion {
    ACUATICA,
    MECANICA,
    MECANICA_DE_ALTURA,

    INFANTIL;

        @Override
        public String toString() {
            return switch (this) {
                case ACUATICA -> "Acuatica";
                case MECANICA -> "Mecanica";
                case MECANICA_DE_ALTURA -> "Mecanica de altura";
                case INFANTIL -> "Infantil";
            };
        }
    }

