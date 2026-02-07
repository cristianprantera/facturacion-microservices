
package com.facturacion.clientes.application;

import org.springframework.stereotype.Service;

import com.facturacion.clientes.domain.exception.ClienteNoEncontradoException;
import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.in.EditarClienteUseCase;
import com.facturacion.clientes.domain.port.out.ClienteRepositoryPort;

@Service
public class EditarClienteUseCaseImpl implements EditarClienteUseCase {
	private final ClienteRepositoryPort repo;

	public EditarClienteUseCaseImpl(ClienteRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Cliente editar(Long id, Cliente cliente) {
		Cliente existing= repo.traerPorId(id)
				.orElseThrow(() -> new ClienteNoEncontradoException(id));
		existing.setNombre(cliente.getNombre());
		existing.setApellido(cliente.getApellido());
		existing.setDni(cliente.getDni());
		existing.setNroCelular(cliente.getNroCelular());
		existing.setEmail(cliente.getEmail());
		
		return repo.actualizar(existing);
		
	}
	
	
}
