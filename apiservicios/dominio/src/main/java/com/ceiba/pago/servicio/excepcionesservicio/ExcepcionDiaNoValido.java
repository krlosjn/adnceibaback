package com.ceiba.pago.servicio.excepcionesservicio;

public class ExcepcionDiaNoValido extends RuntimeException {

    public ExcepcionDiaNoValido(String mensaje){
        super(mensaje);

    }
}
