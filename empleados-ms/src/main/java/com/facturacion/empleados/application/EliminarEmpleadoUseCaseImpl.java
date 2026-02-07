package com.facturacion.empleados.application;

import org.springframework.stereotype.Service;

import com.facturacion.empleados.domain.port.in.EliminarEmpleadoUseCase;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;
@Service
public class EliminarEmpleadoUseCaseImpl implements EliminarEmpleadoUseCase {
	private final EmpleadoRepositoryPort repo;

	public EliminarEmpleadoUseCaseImpl(EmpleadoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public void eliminarEmpleadoPorId(Long id) {
		repo.eliminarEmpleadoPorId(id);
	}
	
	
}
