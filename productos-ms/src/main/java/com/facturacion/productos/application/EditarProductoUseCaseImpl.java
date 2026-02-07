package com.facturacion.productos.application;

import org.springframework.stereotype.Service;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.EditarProductoUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EditarProductoUseCaseImpl implements EditarProductoUseCase {
	
	private final ProductoRepositoryPort repo;
	
	public EditarProductoUseCaseImpl(ProductoRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Producto editar(Long id, Producto producto) {
		Producto existing=repo.buscarPorId(id)
				.orElseThrow(() -> new EntityNotFoundException("Producto con ID: "+id+ " no encontrado"));
		
		existing.setNombre(producto.getNombre());
		existing.setPrecio(producto.getPrecio());
		existing.setCantidadEnStock(producto.getCantidadEnStock());
		
		Producto saved=repo.actualizar(existing);
		
		return saved;
	}
}
