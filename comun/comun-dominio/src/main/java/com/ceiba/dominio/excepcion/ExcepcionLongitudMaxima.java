package com.ceiba.dominio.excepcion;

public class ExcepcionLongitudMaxima extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionLongitudMaxima(String mensaje) {
        super(mensaje);
    }
}
