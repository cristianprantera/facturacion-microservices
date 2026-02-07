package com.facturacion.empleados.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 7, max = 15, message = "El DNI debe tener entre 7 y 15 caracteres")
    private String dni;

    @NotBlank(message = "El número de celular no puede estar vacío")
    @Size(min = 6, max = 20, message = "El número de celular debe tener entre 6 y 20 caracteres")
    private String nroCelular;

    @NotBlank(message = "El legajo no puede estar vacío")
    @Size(min = 2, max = 50, message = "El legajo debe tener entre 2 y 50 caracteres")
    private String legajo;
}
