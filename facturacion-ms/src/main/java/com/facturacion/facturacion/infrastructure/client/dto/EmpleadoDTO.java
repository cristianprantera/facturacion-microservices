package com.facturacion.facturacion.infrastructure.client.dto;

public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String legajo;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getLegajo() { return legajo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setLegajo(String legajo) { this.legajo = legajo; }

    public String getNombreCompleto() {
        String n = nombre == null ? "" : nombre;
        String a = apellido == null ? "" : apellido;
        return (n + " " + a).trim();
    }
}
