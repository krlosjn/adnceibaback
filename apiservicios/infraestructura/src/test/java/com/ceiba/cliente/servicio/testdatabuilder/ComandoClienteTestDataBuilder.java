package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;

    public ComandoClienteTestDataBuilder(){
        this.nombre="Carlos";
        this.tipoIdentificacion="CC";
        this.numeroIdentificacion="1152205388";
    }


    public ComandoClienteTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }


    public ComandoClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion){
        this.tipoIdentificacion=tipoIdentificacion;
        return this;
    }


    public ComandoClienteTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion){
        this.numeroIdentificacion=numeroIdentificacion;
        return this;
    }


    public ComandoCliente build(){
        return new ComandoCliente(id,nombre,tipoIdentificacion,numeroIdentificacion);
    }
}