package com.facturacion.empleados.application;

import org.springframework.stereotype.Service;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.in.ObtenerEmpleadosUseCase;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;

@Service
public class ObtenerEmpleadosUseCaseImpl implements  ObtenerEmpleadosUseCase  {
	private final EmpleadoRepositoryPort repo;

	public ObtenerEmpleadosUseCaseImpl(EmpleadoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Empleado obtenerEmpleadoPorId(Long id) {
		return repo.traerEmpleadoPorId(id)
				.orElseThrow();
	}

	
}
