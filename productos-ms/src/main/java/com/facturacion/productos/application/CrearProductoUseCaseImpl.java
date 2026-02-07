package com.facturacion.productos.application;

import org.springframework.stereotype.Service;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.CrearProductoUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

@Service
public class CrearProductoUseCaseImpl implements CrearProductoUseCase {

	private final ProductoRepositoryPort repo;
	
	public CrearProductoUseCaseImpl(ProductoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Producto crear(Producto producto) {
		return repo.guardar(producto);
	}

}
