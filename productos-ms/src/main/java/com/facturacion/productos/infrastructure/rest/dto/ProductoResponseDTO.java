package com.facturacion.productos.infrastructure.rest.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProductoResponseDTO {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Long cantidadEnStock;
}
