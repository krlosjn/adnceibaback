package com.ceiba.cliente.comando.manejador;

import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pago.servicio.ServicioEliminarPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }
    public void ejecutar(Long id) {
        this.servicioEliminarCliente.ejecutar(id);
    }

}