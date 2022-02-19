package com.ceiba.pago.modelo.entidad.cliente;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Identificacion {

    public static final String EL_TIPO_DE_IDENTIFICACION_NO_PUEDE_SER_NULO = "El tipo de identificacion, no puede ser nulo";
    public static final String EL_NUMERO_NO_PUEDER_ESTAR_VACIO = "Debe ingresar el número de identificación";
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;

    public Identificacion(TipoIdentificacion tipoIdentificacion,String numeroIdentificacion){
        validarObligatorio(tipoIdentificacion,EL_TIPO_DE_IDENTIFICACION_NO_PUEDE_SER_NULO);
        validarObligatorio(numeroIdentificacion, EL_NUMERO_NO_PUEDER_ESTAR_VACIO);
        this.tipoIdentificacion=tipoIdentificacion;
        this.numeroIdentificacion=numeroIdentificacion;
    }

    public boolean validaIdentificacion(Identificacion identificacion){

        if(this.numeroIdentificacion==identificacion.getNumeroIdentificacion() && this.tipoIdentificacion==identificacion.getTipoIdentificacion()){
            return true;
        }
        return false;
    }

    public boolean validaNumeroIdentificacionIgual(Identificacion identificacion){

        if(this.numeroIdentificacion.equals(identificacion.getNumeroIdentificacion())){
            return true;
        }
        return false;
    }

    public boolean validaTipoIdentificacionIgual(Identificacion identificacion){

        if(this.tipoIdentificacion==identificacion.getTipoIdentificacion()){
            return true;
        }
        return false;
    }
}
