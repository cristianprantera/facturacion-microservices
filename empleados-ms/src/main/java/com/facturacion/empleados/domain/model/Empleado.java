package com.facturacion.empleados.domain.model;

public class Empleado {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String nroCelular;
    private String legajo;

    private Empleado(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.dni = builder.dni;
        this.nroCelular = builder.nroCelular;
        this.legajo = builder.legajo;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters (por si los necesitás en mappers/use cases)
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNroCelular() {
        return nroCelular;
    }

    public String getLegajo() {
        return legajo;
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private String apellido;
        private String dni;
        private String nroCelular;
        private String legajo;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder dni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder nroCelular(String nroCelular) {
            this.nroCelular = nroCelular;
            return this;
        }

        public Builder legajo(String legajo) {
            this.legajo = legajo;
            return this;
        }

        public Empleado build() {
            return new Empleado(this);
        }
    }
}
