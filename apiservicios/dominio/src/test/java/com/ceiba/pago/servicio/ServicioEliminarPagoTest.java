package com.ceiba.pago.servicio;

import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPagoTest {

    @Test
    @DisplayName("Deberia eliminar el Pago ")
    void deberiaEliminarElUsuarioLlamandoAlRepositorio() {
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        ServicioEliminarPago servicioEliminarUsuario = new ServicioEliminarPago(repositorioPago);

        servicioEliminarUsuario.ejecutar(1L);

        Mockito.verify(repositorioPago, Mockito.times(1)).eliminar(1L);

    }

}
