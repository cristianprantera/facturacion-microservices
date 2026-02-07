package com.facturacion.clientes.infrastructure.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String nroCelular;
    private String email;
}
