package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;




public interface RepositorioCliente {

    Long crear(Cliente pago);

    void eliminar(Long id);

    boolean existe(String nombre);

    boolean existePorId(Long id);
}
