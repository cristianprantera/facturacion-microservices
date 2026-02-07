package com.facturacion.clientes.application;

import org.springframework.stereotype.Service;

import com.facturacion.clientes.domain.port.in.EliminarClienteUseCase;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;
@Service
public class EliminarClienteUseCaseImpl implements EliminarClienteUseCase {
	private final ClienteRepositoryPort repo;

	public EliminarClienteUseCaseImpl(ClienteRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public void eliminar(Long id) {
		repo.eliminar(id);
	}
}
