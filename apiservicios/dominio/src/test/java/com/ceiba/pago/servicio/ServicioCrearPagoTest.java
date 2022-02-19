package com.ceiba.pago.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.pago.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearPagoTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Pago")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelPago() {
        // arrange
        Pago pago = new PagoTestDataBuilder().build();
        RepositorioPago repositorioUsuario = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioUsuario.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioCrearPago servicioCrearPago = new ServicioCrearPago(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPago.ejecutar(pago), ExcepcionDuplicidad.class,"El pago ya se encuentra en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el pago de manera correcta")
    void deberiaCrearElPago() {
        // arrange
        Pago pago = new PagoTestDataBuilder().build();
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioPago.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPago.crear(pago)).thenReturn(1L);
        ServicioCrearPago servicioCrearPago = new ServicioCrearPago(repositorioPago);
        // act
        Long idPago = servicioCrearPago.ejecutar(pago);
        //- assert
        assertEquals(1L,idPago);
        Mockito.verify(repositorioPago, Mockito.times(1)).crear(pago);
    }
}
