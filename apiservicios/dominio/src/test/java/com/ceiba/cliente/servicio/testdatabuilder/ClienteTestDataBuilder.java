package com.ceiba.cliente.servicio.testdatabuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.Identificacion;
import com.ceiba.cliente.modelo.entidad.TipoIdentificacion;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private Identificacion identificacion;

    public ClienteTestDataBuilder(){
        this.id=1L;
        this.nombre="Carlos";
        this.identificacion= new Identificacion(TipoIdentificacion.CEDULA,"1152205388");
    }

    public ClienteTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ClienteTestDataBuilder conIdentificacion(Identificacion identificacion){
        this.identificacion=identificacion;
        return this;
    }

    public Cliente build(){
        return new Cliente(id,nombre,identificacion);
    }
}
