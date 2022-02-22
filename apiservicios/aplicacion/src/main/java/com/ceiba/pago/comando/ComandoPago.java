package com.ceiba.pago.comando;

import com.ceiba.cliente.comando.ComandoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPago {
    private Long id;
    private String referenciaPago;
    private ComandoCliente cliente;
    private boolean aplicaDescuento;
    private double valorBase;
    private double valorTotal;
    private LocalDate fechaRegistro;
    private LocalDate fechaProximoPago;

    @Override
    public String toString() {
        return "ComandoPago{" +
                "id=" + id +
                ", referenciaPago='" + referenciaPago + '\'' +
                ", cliente=" + cliente +
                ", aplicaDescuento=" + aplicaDescuento +
                ", valorBase=" + valorBase +
                ", valorTotal=" + valorTotal +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaProximoPago=" + fechaProximoPago +
                '}';
    }
}
