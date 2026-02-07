package com.facturacion.empleados.infrastructure.rest.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.infrastructure.rest.dto.EmpleadoRequestDTO;
import com.facturacion.empleados.infrastructure.rest.dto.EmpleadoResponseDTO;

@Component
public class EmpleadoDTOMapper {
	public Empleado requestToDomain(EmpleadoRequestDTO request) {
		return Empleado
				.builder()
				.nombre(request.getNombre())
				.apellido(request.getApellido())
				.dni(request.getDni())
				.nroCelular(request.getNroCelular())
				.legajo(request.getLegajo())
				.build();
	}
	
	
	public EmpleadoResponseDTO domainToResponse(Empleado domain) {
		EmpleadoResponseDTO response= new EmpleadoResponseDTO();
		response.setId(domain.getId());
        response.setNombre(domain.getNombre());
        response.setApellido(domain.getApellido());
        response.setDni(domain.getDni());
        response.setNroCelular(domain.getNroCelular());
        response.setLegajo(domain.getLegajo());
        return response;
	}
}
