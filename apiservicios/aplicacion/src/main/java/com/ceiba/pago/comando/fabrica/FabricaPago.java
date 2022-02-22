package com.ceiba.pago.comando.fabrica;

import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.pago.modelo.entidad.Pago;
import org.springframework.stereotype.Component;

import com.ceiba.pago.comando.ComandoPago;

@Component
public class FabricaPago {

    FabricaCliente fabricaCliente;

    public FabricaPago(FabricaCliente fabricaCliente){
        this.fabricaCliente=fabricaCliente;
    }

    public Pago crear(ComandoPago comandoPago) {
        return new Pago(
                //comandoPago.getId(),
                comandoPago.getReferenciaPago(),
                fabricaCliente.crear(comandoPago.getCliente()),
                comandoPago.isAplicaDescuento(),
                comandoPago.getValorBase(),
                comandoPago.getFechaRegistro()
                );
    }
}