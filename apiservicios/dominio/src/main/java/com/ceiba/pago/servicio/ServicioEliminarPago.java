package com.ceiba.pago.servicio;


import com.ceiba.pago.puerto.repositorio.RepositorioPago;

public class ServicioEliminarPago {

    private final RepositorioPago repositorioPago;

    public ServicioEliminarPago(RepositorioPago repositorioPago){
        this.repositorioPago = repositorioPago;
    }

    public void ejecutar(Long id) {
        this.repositorioPago.eliminar(id);
    }
}
