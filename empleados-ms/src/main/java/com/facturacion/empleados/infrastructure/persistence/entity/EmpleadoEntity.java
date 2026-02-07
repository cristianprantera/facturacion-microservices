package com.facturacion.empleados.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="empleados")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String nroCelular;
    private String legajo;
}
