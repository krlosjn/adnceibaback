package com.ceiba.pago.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pago.servicio.ServicioEliminarPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPago implements ManejadorComando<Long> {

    private final ServicioEliminarPago servicioEliminarPago;

    public ManejadorEliminarPago(ServicioEliminarPago servicioEliminarPago) {
        this.servicioEliminarPago = servicioEliminarPago;
    }
    public void ejecutar(Long idPago) {
        this.servicioEliminarPago.ejecutar(idPago);
    }

}