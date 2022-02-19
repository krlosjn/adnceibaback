package com.ceiba.pago.comando.fabrica;

import com.ceiba.pago.modelo.entidad.pago.Pago;
import org.springframework.stereotype.Component;

import com.ceiba.pago.comando.ComandoPago;

@Component
public class FabricaPago {

    public Pago crear(ComandoPago comandoPago) {
        return new Pago(
                comandoPago.getId(),
                comandoPago.getReferenciaPago(),
                comandoPago.getCliente(),
                comandoPago.isAplicaDescuento(),
                comandoPago.getValorBase(),
                comandoPago.getFechaRegistro()
                );
    }
}