package com.ceiba.pago.servicio;

import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearPago {

    public static final String EL_PAGO_YA_SE_ENCUENTRA_EN_EL_SISTEMA = "El pago ya se encuentra en el sistema";


    private final RepositorioPago repositorioPago;

    public ServicioCrearPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public Long ejecutar(Pago pago) {
        validarExistenciaPrevia(pago);
        return this.repositorioPago.crear(pago);
    }

    private void validarExistenciaPrevia(Pago pago) {
        boolean existe = this.repositorioPago.existePorId(pago.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_SE_ENCUENTRA_EN_EL_SISTEMA);
        }
    }
}
