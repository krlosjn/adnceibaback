package com.ceiba.cliente.servicio.testdatabuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;

    public ClienteTestDataBuilder(){
        this.id=1L;
        this.nombre="Carlos";
        this.tipoIdentificacion="CC";
        this.numeroIdentificacion="1152205388";
    }


    public ClienteTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }


    public ClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion){
        this.tipoIdentificacion=tipoIdentificacion;
        return this;
    }


    public ClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion){
        this.numeroIdentificacion=numeroIdentificacion;
        return this;
    }


    public Cliente build(){
        return new Cliente(id,nombre,tipoIdentificacion,numeroIdentificacion);
    }
}
