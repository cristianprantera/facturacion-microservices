package com.facturacion.productos.domain.model;

import java.math.BigDecimal;

public class Producto {
	
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Long cantidadEnStock;
	
	public Producto(Long id,String nombre,BigDecimal precio,Long cantidadEnStock) {
		this.id=id;
		this.nombre=nombre;
		this.precio=precio;
		this.cantidadEnStock=cantidadEnStock;		
	}
	
	public Producto(String nombre,BigDecimal precio,Long cantidadEnStock) {
		this(null,nombre,precio,cantidadEnStock);
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public Long getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public void setCantidadEnStock(Long cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	
	
}
