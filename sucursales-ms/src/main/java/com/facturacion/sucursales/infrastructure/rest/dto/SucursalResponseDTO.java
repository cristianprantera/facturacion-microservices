package com.facturacion.sucursales.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SucursalResponseDTO {
	private Long id;
	private String nombre;
	private String direccion;
}
