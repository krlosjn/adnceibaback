package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
