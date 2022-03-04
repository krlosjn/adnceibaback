package com.ceiba.cliente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudMaxima;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {


    @Test
    public void deberiaCrearUsuarioNuevo(){
        //arrange
        Cliente clienteUno = new ClienteTestDataBuilder().conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        Cliente clienteDos= new ClienteTestDataBuilder().conNombre("Carlos").conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        //act-assert
        assertEquals("Carlos",clienteDos.getNombre());
        assertTrue(clienteUno.validaNumeroIdentificacionCliente(clienteDos));
        assertTrue(clienteUno.validaTipoIdentificacionCliente(clienteDos));
    }

    @Test
    void validaNombreClienteIgual(){
        //arrange

        Cliente cliente= new ClienteTestDataBuilder().conNombre("Carlos").build();
        Cliente clienteUno= new ClienteTestDataBuilder().conNombre("Carlos").build();
        //act
        boolean result =cliente.validaNombreClienteIgual(clienteUno);
        //assert
        assertTrue(result);
    }

    @Test
    void deberiaFallarSinNombre(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conNombre(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class,"El nombre no puede ser un campo vacío");
    }


    @Test
    void  fallaConNombreMaximoTreintaCaracteres(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conNombre("fulanofulanofulanofulanofulanofulano");
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        },ExcepcionLongitudMaxima.class,"El nombre sólo puede contener 30 caracteres máximo");

    }

    @Test
    void validaTipoIdentificacionIgual(){
        //Arrange
        Cliente clienteUno = new ClienteTestDataBuilder().conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        Cliente clienteDos= new ClienteTestDataBuilder().conNombre("Carlos").conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        // act
        boolean result=clienteUno.validaTipoIdentificacionCliente(clienteDos);
        //assert
        assertTrue(result);
    }

    @Test
    void validaNumeroIdentificacionIgual(){

        //arrange
        Cliente clienteUno = new ClienteTestDataBuilder().conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        Cliente clienteDos= new ClienteTestDataBuilder().conNombre("Carlos").conTipoIdentificacion("CC").conNumeroIdentificacion("1152205388").build();
        //act
        boolean result = clienteUno.validaNumeroIdentificacionCliente(clienteDos);
        //assert
        assertTrue(result);
    }


    @Test
    void deberiaFallarSinTipoIdentificacion(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conTipoIdentificacion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        },ExcepcionValorObligatorio.class,"Tiene que ingresar tipo de documento");
    }

    @Test
    void debeFallarConNumeroCedulaMayorDiez(){
        //arrange
            ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conNumeroIdentificacion("11111111111");
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionLongitudMaxima.class,"El número de identificación no puede tener más diez dígitos");
    }

    @Test
    void debeFallarConNumeroCedulaMenorDiez(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNumeroIdentificacion("111111111");
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionLongitudValor.class,"El número de indentificación no puede tener menos de diez dígitos");

    }

}
