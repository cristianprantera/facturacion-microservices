package com.facturacion.clientes.domain.port.in;

import com.facturacion.clientes.domain.model.Cliente;

public interface EditarClienteUseCase {
	Cliente editar(Long id,Cliente cliente);
}
