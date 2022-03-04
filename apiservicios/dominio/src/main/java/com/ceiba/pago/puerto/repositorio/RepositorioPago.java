package com.ceiba.pago.puerto.repositorio;

import com.ceiba.pago.modelo.entidad.Pago;


public interface RepositorioPago {

    Long crear(Pago pago);

    void eliminar(Long id);

    boolean existe(Long id);

    boolean existePorId(Long id);
}
