package com.ceiba.pago.servicio.testdatabuilder;


import com.ceiba.pago.modelo.entidad.cliente.Cliente;
import com.ceiba.pago.modelo.entidad.cliente.Identificacion;
import com.ceiba.pago.modelo.entidad.cliente.TipoIdentificacion;
import com.ceiba.pago.modelo.entidad.pago.Pago;
import com.ceiba.pago.servicio.excepcionesservicio.ExcepcionDiaNoValido;

import java.time.DayOfWeek;
import java.time.LocalDate;
/**
 * Clase encargada de crear un objeto de prueba
 * **/
public class PagoTestDataBuilder {

    private static final int DIAS_PROXIMO_PAGO=20;
    public static final double PORCENTAJE_DESCUENTO = 0.15;
    public static final String DIA_NO_VALIDO="No se puede pagar este día";

    private Long  id;
    private String referenciaPago;
    private Cliente cliente;
    private boolean aplicaDescuento;
    private double valorBase;
    private double valorTotal;
    private LocalDate fechaRegistro;
    private LocalDate fechaProximoPago;

    public PagoTestDataBuilder() {
        this.id=1L;
        this.referenciaPago ="0000";
        this.cliente=new Cliente(1l,"Carlos",new Identificacion(TipoIdentificacion.CEDULA,"1152205388"));
        this.fechaRegistro= LocalDate.now();
        this.aplicaDescuento=true;
        this.valorBase=1000000;
        generarFechaProximoPagoAuxiliar(fechaRegistro,DIAS_PROXIMO_PAGO);
        generaDescuento(valorBase,PORCENTAJE_DESCUENTO);
    }
    // creamos los métodos que setean una propiedad y retornan el objeto;

    public PagoTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public PagoTestDataBuilder conCliente(Cliente cliente){
        this.cliente=cliente;
        return this;
    }

    public PagoTestDataBuilder conAplicaDescuento(boolean aplicaDescuento){
        this.aplicaDescuento=aplicaDescuento;
        return this;
    }

    public PagoTestDataBuilder  conReferenciaPago(String referenciaPago){
        this.referenciaPago =referenciaPago;
        return this;
    }

    public PagoTestDataBuilder conValorBase(double valorBase){
        this.valorBase=valorBase;
        return this;
    }

    public PagoTestDataBuilder conValorFechaRegistro(LocalDate fechaRegistro){
        this.fechaRegistro=fechaRegistro;
        return this;
    }

    public PagoTestDataBuilder conValorTotal(double valorTotal){
        this.valorTotal=valorTotal;
        return this;
    }

    public  void generaDescuento(double valorBase,double PORCENTAJE_DESCUENTO){
        double valorDescuento= valorBase* PORCENTAJE_DESCUENTO;
        if(this.aplicaDescuento){
            this.valorTotal=this.valorBase-valorDescuento;
        }else{
            this.valorTotal=this.valorBase;
        }
    }

    public static void validaDiaPago(LocalDate fechaRegistro){
        if(fechaRegistro.getDayOfWeek().equals(DayOfWeek.SATURDAY)|| fechaRegistro.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            throw new ExcepcionDiaNoValido(DIA_NO_VALIDO);
        }
    }

    public Pago build(){
        return new Pago(id, referenciaPago, cliente,aplicaDescuento,valorBase,fechaRegistro);
    }


    public  static LocalDate generarFechaProximoPagoAuxiliar(LocalDate fechaRegistro, int diasProximoPago) {

        int incrementoDias = 0;
        LocalDate fechaActual = LocalDate.now();
        while (incrementoDias < diasProximoPago) {
            fechaRegistro = fechaRegistro.plusDays(1);
            if (DayOfWeek.SATURDAY != fechaRegistro.getDayOfWeek()
                    && DayOfWeek.SUNDAY != fechaRegistro.getDayOfWeek()) {
                incrementoDias++;
            }
        }
        return fechaRegistro;
    }

    // eliminar esté método
    public static void main(String[] args) {
        Pago pago= new PagoTestDataBuilder().build();
        System.out.println(pago.toString());
    }
}