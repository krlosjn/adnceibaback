package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

/***
 * clase encargada de manejar la lógica de negocio para crear clientes
 * @author carlos.junco
 * @version 1.0.0
 */
public class ServicioCrearCliente {

    public static final String EL_CLIENTE_YA_SE_ENCUENTRA_EN_EL_SISTEMA = "El cliente ya se encuentra en el sistema";

    private final RepositorioCliente repositorioCliente;
    /**
     * constructor de la clase, la cual recibe un objeto tipo RepositorioPago
     * @param repositorioCliente
     */
    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }
    /**
     * Método ejecutar que se encarga de realizar el proceso de pago
     * @param  cliente
     * @return id
    **/
    public Long ejecutar(Cliente cliente) {
        validarExistenciaPrevia(cliente);
        return this.repositorioCliente.crear(cliente);
    }

    /**
     * método que valida por el id ,  si un cliente se encuentra realizado
     * @param  cliente
     * **/
    private void validarExistenciaPrevia(Cliente cliente) {
        boolean existe = this.repositorioCliente.existePorId(cliente.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_CLIENTE_YA_SE_ENCUENTRA_EN_EL_SISTEMA);
        }
    }
}
