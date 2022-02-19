package com.ceiba.pago.modelo.entidad.cliente;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudMaxima;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pago.servicio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Carlos Junco
 * Clase que se encarga de probar la creación de un cliente nuevo
 * **/
public class ClienteTest {

    /**
     * método que se se encarga de crear un nombre de prueba
     * **/

    @Test
    public void deberiaCrearUsuarioNuevo(){
    //arrange
        Cliente clienteUno = new ClienteTestDataBuilder().conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"1152205388")).build();
        Cliente clienteDos= new ClienteTestDataBuilder().conNombre("Carlos").
                conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"1152205388")).build();
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
    void validaIdentificacionIgual(){
        //Arrange
        Cliente clienteUno = new ClienteTestDataBuilder().conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"1152205388")).build();
        Cliente clienteDos = new ClienteTestDataBuilder().conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"1152205388")).build();
        // act
        boolean result=clienteUno.validaIdentificacionIgual(clienteDos);
        //assert
        assertTrue(result);
    }

    @Test
    void deberiaFallarSinIdentificacion(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conIdentificacion(null);
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        },ExcepcionValorObligatorio.class,"Tiene que ingresar la identificación  del cliente");
    }

    @Test
    void debeFallarConNumeroCedulaMayorDiez(){
        //arrange
            ClienteTestDataBuilder clienteTestDataBuilder= new ClienteTestDataBuilder().conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"11111111111"));
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionLongitudMaxima.class,"El número de identificación no puede tener más diez dígitos");
    }

    @Test
    void debeFallarConNumeroCedulaMenorDiez(){
        //arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conIdentificacion(new Identificacion(TipoIdentificacion.CEDULA,"111111111"));
        //act-assert
        BasePrueba.assertThrows(()->{
            clienteTestDataBuilder.build();
        }, ExcepcionLongitudValor.class,"El número de indentificación no puede tener menos de diez dígitos");

    }

}
