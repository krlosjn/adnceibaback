package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.pago.comando.ComandoPago;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ComandoPagoTestDataBuilder {
    public static final int DIAS_PROXIMO_PAGO = 20;
    public static final double PORCENTAJE_DESCUENTO = 0.15;
    private Long id;
    private String referenciaPago;
    private ComandoCliente cliente;
    private boolean aplicaDescuento;
    private double valorBase;
    private double valorTotal;
    private LocalDate fechaRegistro;
    private LocalDate fechaProximoPago;;

    public ComandoPagoTestDataBuilder() {
        this.id=2L;
        this.referenciaPago="1111";
        this.cliente= null;
        this.aplicaDescuento=true;
        this.valorBase=200000;
        this.fechaRegistro = LocalDate.now();
        generarFechaProximoPago(fechaRegistro, DIAS_PROXIMO_PAGO);
        generaDescuento(valorBase, PORCENTAJE_DESCUENTO);
    }


    public ComandoPagoTestDataBuilder conReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
        return this;
    }
    public ComandoPagoTestDataBuilder conAplicaDescuento(boolean aplicaDescuento) {
        this.aplicaDescuento = aplicaDescuento;
        return this;
    }

    public ComandoPagoTestDataBuilder conAplicaConValorBase(double valorBase) {
        this.valorBase = valorBase;
        return this;
    }

    public ComandoPagoTestDataBuilder conCliente(ComandoCliente comandoCliente){
        this.cliente=comandoCliente;
        return this;
    }

    public ComandoPagoTestDataBuilder conAplicaConFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaProximoPago = fechaVencimiento;
        return this;
    }
    public void generarFechaProximoPago(LocalDate fechaRegistro, int diasProximoPago) {

        int incrementoDias = 0;
        LocalDate fechaActual = LocalDate.now();
        while (incrementoDias < diasProximoPago) {
            fechaRegistro = fechaRegistro.plusDays(1);
            if (DayOfWeek.SATURDAY != fechaRegistro.getDayOfWeek()
                    && DayOfWeek.SUNDAY != fechaRegistro.getDayOfWeek()) {
                incrementoDias++;
            }
        }
        this.fechaProximoPago=fechaRegistro;
    }

    public void generaDescuento(double valorBase,double PORCENTAJE_DESCUENTO){
        double valorDescuento= valorBase* PORCENTAJE_DESCUENTO;
        if(this.aplicaDescuento){
            this.valorTotal=this.valorBase-valorDescuento;
        }else{
            this.valorTotal=this.valorBase;
        }
    }

    public ComandoPago build() {
        return new ComandoPago(id, referenciaPago, cliente,aplicaDescuento,valorBase,valorTotal,fechaRegistro, fechaProximoPago);
    }

}