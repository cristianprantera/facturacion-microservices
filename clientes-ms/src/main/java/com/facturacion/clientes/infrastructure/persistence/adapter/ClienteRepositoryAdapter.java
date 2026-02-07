package com.facturacion.clientes.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;
import com.facturacion.clientes.infrastructure.persistence.entity.ClienteEntity;
import com.facturacion.clientes.infrastructure.persistence.mapper.ClienteJpaMapper;
import com.facturacion.clientes.infrastructure.persistence.repository.ClienteJpaRepository;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {
	private final ClienteJpaRepository repo;
	private final ClienteJpaMapper mapper;
	
	public ClienteRepositoryAdapter(ClienteJpaRepository repo,ClienteJpaMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		ClienteEntity entity=mapper.domainToEntity(cliente);
		ClienteEntity saved=repo.save(entity);
		return mapper.entityToDomain(saved);
		
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
	    return guardar(cliente);

	}

	@Override
	public List<Cliente> listar() {
		return repo.findAll().stream().map(mapper::entityToDomain).toList();
	}

	@Override
	public void eliminar(Long id) {		
		repo.deleteById(id);
	}

	@Override
	public Optional<Cliente> traerPorId(Long id) {
		return repo.findById(id).map(mapper::entityToDomain);
	}
	
	
}
