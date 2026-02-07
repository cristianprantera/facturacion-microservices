package com.facturacion.empleados.application;

import org.springframework.stereotype.Service;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.in.CrearEmpleadoUseCase;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;

@Service
public class CrearEmpleadoUseCaseImpl implements CrearEmpleadoUseCase{

	private final EmpleadoRepositoryPort repo;
	
	
	
	public CrearEmpleadoUseCaseImpl(EmpleadoRepositoryPort repo) {
		this.repo = repo;
	}



	@Override
	public Empleado crearEmpleado(Empleado empleado) {
		return repo.guardarEmpleado(empleado);
	}

}
