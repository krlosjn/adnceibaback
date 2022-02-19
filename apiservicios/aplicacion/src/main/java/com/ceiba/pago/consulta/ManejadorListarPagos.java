package com.ceiba.pago.consulta;

import java.util.List;

import com.ceiba.pago.puerto.dao.DaoPago;
import org.springframework.stereotype.Component;

import com.ceiba.pago.modelo.dto.DtoPago;

@Component
public class ManejadorListarPagos {

    private final DaoPago daoPago;

    public ManejadorListarPagos(DaoPago daoPago){
        this.daoPago = daoPago;
    }

    public List<DtoPago> ejecutar(){ return this.daoPago.listar(); }
}
