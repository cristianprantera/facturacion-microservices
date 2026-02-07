package com.facturacion.sucursales.infrastructure.persistence.adapter;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;
import com.facturacion.sucursales.infrastructure.persistence.entity.SucursalEntity;
import com.facturacion.sucursales.infrastructure.persistence.mapper.SucursalJpaMapper;
import com.facturacion.sucursales.infrastructure.persistence.repository.SucursalJpaRepository;

@Component
public class SucursalRepositoryAdapter implements SucursalRepositoryPort {
	private final SucursalJpaRepository repo;
	private final SucursalJpaMapper mapper;

	public SucursalRepositoryAdapter(SucursalJpaRepository repo, SucursalJpaMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public Sucursal guardar(Sucursal sucursal) {
		SucursalEntity entity=mapper.domainToEntity(sucursal);
		SucursalEntity saved=repo.save(entity);
		return mapper.entityToDomain(saved);
	}

	@Override
	public Sucursal actualizar(Sucursal sucursal) {
		return guardar(sucursal);

	}

	@Override
	public List<Sucursal> listar() {
		List<SucursalEntity> lst=repo.findAll();
		return lst.stream().map(mapper::entityToDomain).toList();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Sucursal> obtenerPorId(Long id) {
		return repo.findById(id)
				.map(mapper::entityToDomain);
	}
	
	
}
