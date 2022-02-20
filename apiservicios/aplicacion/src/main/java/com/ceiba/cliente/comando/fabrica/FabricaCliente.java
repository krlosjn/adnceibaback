package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pago.modelo.entidad.Pago;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getId(),
                comandoCliente.getNombre(),
                comandoCliente.getIdentificacion()
                );
    }
}