package com.facturacion.productos.application;

import org.springframework.stereotype.Service;

import com.facturacion.productos.domain.port.in.EliminarProductoUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

@Service
public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase  {
	
	private final ProductoRepositoryPort repo;
	
	public EliminarProductoUseCaseImpl(ProductoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public void eliminar(Long id) {
		repo.eliminar(id);
	}
}
