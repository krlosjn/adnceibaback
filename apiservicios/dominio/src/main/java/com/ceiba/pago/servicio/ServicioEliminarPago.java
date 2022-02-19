package com.ceiba.pago.servicio;


import com.ceiba.pago.puerto.repositorio.RepositorioPago;

/**
 * Clase que se encarga de eliminar un servicio
 * **/
public class ServicioEliminarPago {

    private final RepositorioPago repositorioPago;

    public ServicioEliminarPago(RepositorioPago repositorioPago){
        this.repositorioPago = repositorioPago;
    }

    public void ejecutar(Long id) {
        this.repositorioPago.eliminar(id);
    }
}
