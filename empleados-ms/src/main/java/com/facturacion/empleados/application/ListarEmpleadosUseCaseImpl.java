package com.facturacion.empleados.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.in.ListarEmpleadosUseCase;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;
@Service
public class ListarEmpleadosUseCaseImpl implements ListarEmpleadosUseCase {
	private final EmpleadoRepositoryPort repo;

	public ListarEmpleadosUseCaseImpl(EmpleadoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public List<Empleado> listar() {
		return repo.listarEmpleados();
	}
	
	

}
