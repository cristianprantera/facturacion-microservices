package com.facturacion.clientes.application;

import org.springframework.stereotype.Service;

import com.facturacion.clientes.domain.exception.ClienteNoEncontradoException;
import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.in.ObtenerClienteUseCase;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;

@Service
public class ObtenerClienteUseCaseImpl implements ObtenerClienteUseCase {
	private final ClienteRepositoryPort repo;

	public ObtenerClienteUseCaseImpl(ClienteRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Cliente obtenerClientePorId(Long id) {
		return repo.traerPorId(id)
				.orElseThrow(() -> new ClienteNoEncontradoException(id));
	}
}
