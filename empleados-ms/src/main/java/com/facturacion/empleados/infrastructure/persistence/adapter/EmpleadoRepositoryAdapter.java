package com.facturacion.empleados.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.out.EmpleadoRepositoryPort;
import com.facturacion.empleados.infrastructure.persistence.entity.EmpleadoEntity;
import com.facturacion.empleados.infrastructure.persistence.mapper.EmpleadoJpaMapper;
import com.facturacion.empleados.infrastructure.persistence.repository.EmpleadoJpaRepository;

@Component
public class EmpleadoRepositoryAdapter implements EmpleadoRepositoryPort {
	
	private final EmpleadoJpaMapper mapper;
	private final EmpleadoJpaRepository repo;
	
	
	public EmpleadoRepositoryAdapter(EmpleadoJpaMapper mapper, EmpleadoJpaRepository repo) {
		this.mapper = mapper;
		this.repo = repo;
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		EmpleadoEntity entity=mapper.domainToEntity(empleado);	
		EmpleadoEntity saved= repo.save(entity);
		return mapper.entityToDomain(saved);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return guardarEmpleado(empleado);
	}

	@Override
	public void eliminarEmpleadoPorId(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Empleado> traerEmpleadoPorId(Long id) {
		return repo.findById(id).map(mapper::entityToDomain);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return repo.findAll()
				.stream()
				.map(mapper::entityToDomain)
				.toList();
	}

}
