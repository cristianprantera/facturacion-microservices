package com.facturacion.clientes.application;

import org.springframework.stereotype.Service;

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.in.CrearClienteUseCase;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;

@Service
public class CrearClienteUseCaseImpl implements CrearClienteUseCase{
	private final ClienteRepositoryPort repo;

	public CrearClienteUseCaseImpl(ClienteRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Cliente crear(Cliente cliente) {
		return repo.guardar(cliente);
	}
	
	
}
