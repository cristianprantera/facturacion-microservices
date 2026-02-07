package com.facturacion.empleados.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoResponseDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String nroCelular;
    private String legajo;
}
