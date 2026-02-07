package com.facturacion.empleados.application;

import org.springframework.stereotype.Service;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.in.EditarEmpleadoUseCase;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;
@Service
public class EditarEmpleadoUseCaseImpl implements EditarEmpleadoUseCase {
	private final EmpleadoRepositoryPort repo;

	public EditarEmpleadoUseCaseImpl(EmpleadoRepositoryPort repo) {
		this.repo = repo;
	}

    @Override
    public Empleado editarEmpleadoPorId(Long id, Empleado empleado) {
        Empleado existing = repo.traerEmpleadoPorId(id)
                .orElseThrow();

        // Creamos un NUEVO Empleado usando el builder
        Empleado actualizado = Empleado.builder()
                .id(existing.getId())                   
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .dni(empleado.getDni())
                .nroCelular(empleado.getNroCelular())
                .legajo(empleado.getLegajo())
                .build();

        return repo.actualizarEmpleado(actualizado);
    }
	
	
}
