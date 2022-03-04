package com.ceiba.cliente.servicio;


import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;


public class ServicioEliminarCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        this.repositorioCliente.eliminar(id);
    }
}
