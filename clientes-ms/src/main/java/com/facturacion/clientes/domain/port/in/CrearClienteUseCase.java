package com.facturacion.clientes.domain.port.in;

import com.facturacion.clientes.domain.model.Cliente;

public interface CrearClienteUseCase {
	 Cliente crear(Cliente cliente);
}
