package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {

    public static final String EL_NOMBRE_NO_PUEDE_SER_UN_CAMPO_VACIO = "El nombre no puede ser un campo vacío";
    public static final String NUMERO_IDENTIFICACION_MAYOR = "El número de identificación no puede tener más diez dígitos";
    public static final String NUMERO_IDENTIFICACION_MENOR = "El número de indentificación no puede tener menos de diez dígitos";
    public static final String NOMBRE_MAXIMO="El nombre sólo puede contener 30 caracteres máximo";
    public static final String TIENE_QUE_INGRESAR_TIPO_DE_DOCUMENTO = "Tiene que ingresar tipo de documento";


    @Setter
    private Long id;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;

    public Cliente( Long id,String nombre, String tipoIdentificacion, String numeroIdentificacion){
        validarObligatorio(nombre, EL_NOMBRE_NO_PUEDE_SER_UN_CAMPO_VACIO);
        validarLongitudMaxima(nombre,30,NOMBRE_MAXIMO);
        validarObligatorio(tipoIdentificacion, TIENE_QUE_INGRESAR_TIPO_DE_DOCUMENTO);
        validarLongitudMaxima(numeroIdentificacion,10, NUMERO_IDENTIFICACION_MAYOR);
        validarLongitudMinima(numeroIdentificacion,10, NUMERO_IDENTIFICACION_MENOR);
        this.id=id;
        this.nombre=nombre;
        this.tipoIdentificacion=tipoIdentificacion;
        this.numeroIdentificacion=numeroIdentificacion;
    }

    public boolean validaNumeroIdentificacionCliente(Cliente cliente){

        return this.numeroIdentificacion.equals(cliente.numeroIdentificacion);

    }

    public boolean validaTipoIdentificacionCliente(Cliente cliente){
        return this.tipoIdentificacion.equals(cliente.tipoIdentificacion);
    }

    public boolean validaNombreClienteIgual(Cliente cliente){
        return this.nombre.equals(cliente.getNombre());
    }

}
