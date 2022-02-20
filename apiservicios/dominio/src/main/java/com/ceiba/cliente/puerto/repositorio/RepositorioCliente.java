package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;


/**
 * Interfaz que se sirve como un asbtracción de acceso a datos
 * @author carlos.junco
 * @version 1.0.0
 * **/


public interface RepositorioCliente {
    /**
     * Permite crear  un pago de un servicio
     * @param pago
     * @return el id generado
     */
    Long crear(Cliente pago);

    /**
     * Permite actualizar un pago que se encuentre en el sistema
     * @param usuario
     */
    void actualizar(Cliente usuario);

    /**
     * Permite eliminar un pago
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pago asociado a un usuario
     * @param referenciaPago
     * @return si existe o no
     */
    boolean existe(String referenciaPago);

    /**
     * Permite validar si existe un pago con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
