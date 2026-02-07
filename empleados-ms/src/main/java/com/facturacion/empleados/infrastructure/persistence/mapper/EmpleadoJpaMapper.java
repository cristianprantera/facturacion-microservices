package com.facturacion.empleados.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.infrastructure.persistence.entity.EmpleadoEntity;

@Component
public class EmpleadoJpaMapper {
	public Empleado entityToDomain(EmpleadoEntity entity) {
		return Empleado.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.apellido(entity.getApellido())
				.dni(entity.getDni())
				.nroCelular(entity.getNroCelular())
				.legajo(entity.getLegajo())
				.build();
	}
	
	
	public EmpleadoEntity domainToEntity(Empleado domain) {
		EmpleadoEntity entity=new EmpleadoEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		entity.setApellido(domain.getApellido());
		entity.setDni(domain.getDni());
		entity.setNroCelular(domain.getNroCelular());
		entity.setLegajo(domain.getLegajo());
		return entity;
	}
}
