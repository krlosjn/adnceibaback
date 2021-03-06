package com.ceiba.pago.comando;

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
    private Long cliente;
    private boolean aplicaDescuento;
    private double valorBase;
    private double valorTotal;
    private LocalDate fechaRegistro;
    private LocalDate fechaProximoPago;

}
