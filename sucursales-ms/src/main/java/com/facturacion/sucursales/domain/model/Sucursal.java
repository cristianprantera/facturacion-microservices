package com.facturacion.sucursales.domain.model;

public class Sucursal {
	private Long id;
	private String nombre;
	private String direccion;
	
	public Sucursal(Long id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Sucursal(String nombre, String direccion) {
		this(null,nombre,direccion);
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
