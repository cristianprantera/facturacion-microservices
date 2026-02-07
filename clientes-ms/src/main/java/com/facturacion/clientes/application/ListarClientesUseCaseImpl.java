package com.facturacion.clientes.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.in.ListarClientesUseCase;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;
@Service
public class ListarClientesUseCaseImpl implements ListarClientesUseCase {
	private final ClienteRepositoryPort repo;

	public ListarClientesUseCaseImpl(ClienteRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public List<Cliente> listar() {
		return repo.listar();
	}
	
	
}
