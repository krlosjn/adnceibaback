package com.ceiba.pago.controlador;

import java.util.List;

import com.ceiba.pago.consulta.ManejadorListarPagos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.pago.modelo.dto.DtoPago;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pagos")
@Api(tags={"Controlador consulta pagos"})
public class ConsultaControladorPago {

    private final ManejadorListarPagos manejadorListarPagos;

    public ConsultaControladorPago(ManejadorListarPagos manejadorListarPagos) {
        this.manejadorListarPagos = manejadorListarPagos;
    }

    @GetMapping
    @ApiOperation("Listar pagos")
    public List<DtoPago> listar() {
        return this.manejadorListarPagos.ejecutar();
    }

}
