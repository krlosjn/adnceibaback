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
     * Permite eliminar un pago
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pago asociado a un usuario
     * @param  nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un pago con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
