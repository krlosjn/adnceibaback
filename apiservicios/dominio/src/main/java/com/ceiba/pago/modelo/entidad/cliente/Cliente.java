package com.ceiba.pago.modelo.entidad.cliente;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {

    public static final String EL_NOMBRE_NO_PUEDE_SER_UN_CAMPO_VACIO = "El nombre no puede ser un campo vacío";
    public static final String TIENE_QUE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE = "Tiene que ingresar la identificación  del cliente";
    public static final String NUMERO_IDENTIFICACION_MAYOR = "El número de identificación no puede tener más diez dígitos";
    public static final String NUMERO_IDENTIFICACION_MENOR = "El número de indentificación no puede tener menos de diez dígitos";
    public static final String NOMBRE_MAXIMO="El nombre sólo puede contener 30 caracteres máximo";


    private Long id;
    private String nombre;
    private Identificacion identificacion;

    public Cliente(Long id, String nombre,Identificacion identificacion){
        validarObligatorio(nombre, EL_NOMBRE_NO_PUEDE_SER_UN_CAMPO_VACIO);
        validarLongitudMaxima(nombre,30,NOMBRE_MAXIMO);
        validarObligatorio(identificacion, TIENE_QUE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE);
        validarLongitudMaxima(identificacion.getNumeroIdentificacion(),10, NUMERO_IDENTIFICACION_MAYOR);
        validarLongitudMinima(identificacion.getNumeroIdentificacion(),10, NUMERO_IDENTIFICACION_MENOR);
        this.id=id;
        this.identificacion=identificacion;
        this.nombre=nombre;
    }

    public boolean validaNumeroIdentificacionCliente(Cliente cliente){
        return this.identificacion.validaNumeroIdentificacionIgual(cliente.getIdentificacion());
    }

    public boolean validaTipoIdentificacionCliente(Cliente cliente){
        return this.identificacion.validaTipoIdentificacionIgual(cliente.getIdentificacion());
    }

    public boolean validaIdentificacionIgual(Cliente cliente){
       return this.identificacion.validaIdentificacion(cliente.getIdentificacion());
    }

    public boolean validaNombreClienteIgual(Cliente cliente){
        return this.nombre.equals(cliente.getNombre());
    }


    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "Carlos",new Identificacion(TipoIdentificacion.CEDULA,"1152205388"));

        System.err.println(cliente.toString());
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion.getTipoIdentificacion() +
                " numero de identificacion " + identificacion.getNumeroIdentificacion()+
                '}';
    }
}
