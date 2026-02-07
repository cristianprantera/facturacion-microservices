package com.facturacion.sucursales.infrastructure.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SucursalRequestDTO {
	
	@NotBlank(message="El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede tener más de 30 caracteres")
	private String nombre;
	
	@NotBlank(message="La direccion no puede estar vacío")
    @Size(max = 30, message = "La direccion no puede tener más de 30 caracteres")
	private String direccion;
}
