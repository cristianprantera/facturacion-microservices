package com.facturacion.clientes.domain.model;

public class Cliente {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
	private String nroCelular;
	private String email;
	
	public Cliente(Long id, String nombre, String apellido, String dni, String nroCelular, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nroCelular = nroCelular;
		this.email = email;
	}
	
	public Cliente(String nombre, String apellido, String dni, String nroCelular, String email) {
		this(null,nombre,apellido,dni,nroCelular,email);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNroCelular() {
		return nroCelular;
	}

	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
