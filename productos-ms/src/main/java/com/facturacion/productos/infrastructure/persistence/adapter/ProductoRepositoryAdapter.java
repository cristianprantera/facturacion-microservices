package com.facturacion.productos.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;
import com.facturacion.productos.infrastructure.persistence.entity.ProductoEntity;
import com.facturacion.productos.infrastructure.persistence.mapper.ProductoJpaMapper;
import com.facturacion.productos.infrastructure.persistence.repository.ProductoJpaRepository;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

	private final ProductoJpaRepository repo;
	private final ProductoJpaMapper mapper;	
	
	
	public ProductoRepositoryAdapter(ProductoJpaRepository repo,ProductoJpaMapper mapper) {
		this.repo = repo;
		this.mapper=mapper;
	}

	@Override
	public Producto guardar(Producto producto) {
		ProductoEntity entity= mapper.domainToEntity(producto);
		ProductoEntity saved=repo.save(entity);
		return mapper.entityToDomain(saved);
		
		
	}

	@Override
	public Optional<Producto> buscarPorId(Long id) {
		return repo.findById(id).map(mapper::entityToDomain);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Producto> listar() {
		return 	 repo.findAll()
				.stream()
				.map(mapper::entityToDomain)
				.toList();
	}

	@Override
	public Producto actualizar(Producto producto) {
	    ProductoEntity existing = repo.findById(producto.getId())
	            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

	    existing.setNombre(producto.getNombre());
	    existing.setPrecio(producto.getPrecio());
	    existing.setCantidadEnStock(producto.getCantidadEnStock());

	    ProductoEntity saved = repo.save(existing);

	    return mapper.entityToDomain(saved);
	}


}
