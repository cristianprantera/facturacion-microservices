package com.facturacion.clientes.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.infrastructure.persistence.entity.ClienteEntity;

@Component
public class ClienteJpaMapper {
	public Cliente entityToDomain(ClienteEntity entity) {
		return new Cliente(entity.getId(),
				entity.getNombre(),
				entity.getApellido(),
				entity.getDni(),
				entity.getNroCelular(),
				entity.getEmail());
	}
	
	public ClienteEntity domainToEntity(Cliente cliente) {
		ClienteEntity entity=new ClienteEntity();
		entity.setId(cliente.getId());
		entity.setNombre(cliente.getNombre());
		entity.setApellido(cliente.getApellido());
		entity.setDni(cliente.getDni());
		entity.setNroCelular(cliente.getNroCelular());
		entity.setEmail(cliente.getEmail());
		
		return entity;
	}
}
