package com.facturacion.clientes.domain.port.in;

import java.util.List;

import com.facturacion.clientes.domain.model.Cliente;

public interface ListarClientesUseCase {
	List<Cliente> listar();
}
