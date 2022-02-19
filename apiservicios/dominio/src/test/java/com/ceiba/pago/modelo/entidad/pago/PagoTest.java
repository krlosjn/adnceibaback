package com.ceiba.pago.modelo.entidad.pago;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pago.modelo.entidad.pago.Pago;
import com.ceiba.pago.servicio.excepcionesservicio.ExcepcionDiaNoValido;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder.generarFechaProximoPagoAuxiliar;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PagoTest {

    @Test
    @DisplayName("Deberia crear correctamente el pago")
    void deberiaCrearCorrectamenteElPago() {
        // arrange
        LocalDate fechaRegistro = LocalDate.now();;
        //act
        Pago pago= new PagoTestDataBuilder().conValorFechaRegistro(fechaRegistro).conId(1L).build();
        //assert
        assertEquals(1L, pago.getId());
        assertEquals("0000",pago.getReferenciaPago());
        assertEquals(1000000,pago.getValorBase());
        assertEquals(850000.0,pago.getValorTotal());
        assertEquals(fechaRegistro, pago.getFechaRegistro());
    }

    @Test
    void tomaFechaRegistroCorrectamente(){
        //arrange
        LocalDate fechaRegistro= LocalDate.of(2022,02,14);
        Pago pago = new PagoTestDataBuilder().conValorFechaRegistro(fechaRegistro).build();
        //act-assert
        assertEquals(LocalDate.of(2022,02,14),pago.getFechaRegistro());
    }


    /**Toca validar bien este método por que toma un día quemado**/
    @Test
    void validaFechaProximoPago(){
        //arrange
        LocalDate fechaPago= LocalDate.now();
        LocalDate fechaProximoPagoEsperada= generarFechaProximoPagoAuxiliar(fechaPago,20);
        Pago pago= new PagoTestDataBuilder().conValorFechaRegistro(fechaPago).build();
        //act
        LocalDate fechaProximoPago=pago.getFechaProximoPago();
        //assert
        assertEquals(fechaProximoPagoEsperada,fechaProximoPago);
    }

    // método de ayuda para setear una fecha actual

    @Test
    void validaFechaIncorrectaPagoDomingo(){
        //arrange
        LocalDate fechaDomingo= LocalDate.of(2022,02,13);
        PagoTestDataBuilder pagoTestDataBuilder= new PagoTestDataBuilder().conValorFechaRegistro(fechaDomingo);
        //act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        }, ExcepcionDiaNoValido.class,"No se puede pagar este día");
    }

    @Test
    void validaFechaIncorrectaPagoSabado(){
        //arrange
        LocalDate fechaSabado= LocalDate.of(2022,02,12);
        PagoTestDataBuilder pagoTestDataBuilder= new PagoTestDataBuilder().conValorFechaRegistro(fechaSabado);
        //act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        }, ExcepcionDiaNoValido.class,"No se puede pagar este día");

    }

    @Test
    void deberiaFallarSinReferenciaPago(){
        //arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conReferenciaPago(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                     pagoTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class,"Se debe ingresar referencia de pago");
    }

    @Test
    void fallaConReferenciaPagoMayorCuatroCaracteres(){
        //arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conReferenciaPago("123456");
        //act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        },ExcepcionValorInvalido.class,"La referencia de pago debe tener 4 dígitos");
    }

    @Test
    void fallaConReferenciaPagoMenorCuatroCaracteres(){
        //arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conReferenciaPago("123");

        //act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        },ExcepcionValorInvalido.class,"La referencia de pago debe tener 4 dígitos");
    }

    @Test
    void deberiaFallarSinFechaRegistro() {
        //Arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conValorFechaRegistro(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagoTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de registro");
    }


    @Test
    void ValorBaseCeroFalla(){
        //Arrange
        Double prof=null;
        PagoTestDataBuilder pagoTestDataBuilder= new PagoTestDataBuilder().conValorBase(0).conId(1L);
        //Act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        }, ExcepcionValorInvalido.class,"Se debe ingresar un valor mayor a cero");
    }


    @Test
    void fallaSiValorBaseSuperaMillon(){
        //arrange
        PagoTestDataBuilder pagoTestDataBuilder= new PagoTestDataBuilder().conValorBase(100000000);
        //act-assert
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        },ExcepcionValorInvalido.class, "El valor debe estar entre 100000 y 1000000");
    }

    @Test
    void fallaSiValorBaseEsInferiorCienMil(){
        //arrange
        PagoTestDataBuilder pagoTestDataBuilder= new PagoTestDataBuilder().conValorBase(10000);
        //act-arrange
        BasePrueba.assertThrows(()->{
            pagoTestDataBuilder.build();
        },ExcepcionValorInvalido.class,"El valor debe estar entre 100000 y 1000000");
    }


}
