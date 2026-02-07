package com.facturacion.clientes.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.facturacion.clientes.domain.model.Cliente;

public interface ClienteRepositoryPort {
	 Cliente guardar(Cliente cliente);
	 Cliente actualizar(Cliente cliente);
	 List<Cliente> listar();
	 void eliminar(Long id);
	 Optional<Cliente> traerPorId(Long id);
}
