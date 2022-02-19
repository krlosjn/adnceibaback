package com.ceiba.pago.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.manejador.ManejadorCrearPago;
import com.ceiba.pago.comando.manejador.ManejadorEliminarPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pagos")
@Api(tags = { "Controlador comando pago"})
public class ComandoControladorPago {

    private final ManejadorCrearPago manejadorCrearPago;
	private final ManejadorEliminarPago manejadorEliminarPago;

    @Autowired
    public ComandoControladorPago(ManejadorCrearPago manejadorCrearPago,
                                  ManejadorEliminarPago manejadorEliminarPago) {
        this.manejadorCrearPago = manejadorCrearPago;
		this.manejadorEliminarPago = manejadorEliminarPago;
    }

    @PostMapping
    @ApiOperation("Crear Pago")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPago comandoPago) {
        return manejadorCrearPago.ejecutar(comandoPago);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar pago")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPago.ejecutar(id);
    }

}
