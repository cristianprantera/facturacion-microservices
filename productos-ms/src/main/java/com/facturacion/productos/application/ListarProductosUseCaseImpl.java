package com.facturacion.productos.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.ListarProductosUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

@Service
public class ListarProductosUseCaseImpl implements ListarProductosUseCase {
	private final ProductoRepositoryPort repo;
	
	public ListarProductosUseCaseImpl(ProductoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public List<Producto> listar() {
		return repo.listar();
	}
}
