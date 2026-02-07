package com.facturacion.productos.application;

import org.springframework.stereotype.Service;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.ObtenerProductoUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ObtenerProductoUseCaseImpl implements ObtenerProductoUseCase{
private final ProductoRepositoryPort repo;
	
	public ObtenerProductoUseCaseImpl(ProductoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return repo.buscarPorId(id)
				.orElseThrow(
				() -> new EntityNotFoundException("Producto con ID: "+id+ " no encontrado"));
	}
}
