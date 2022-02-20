package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {
    /**
     * Permite listar clientes
     * @return los clientes
     */
    List<DtoCliente> listar();
}
