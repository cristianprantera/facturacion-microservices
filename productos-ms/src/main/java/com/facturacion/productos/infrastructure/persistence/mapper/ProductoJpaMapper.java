package com.facturacion.productos.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.infrastructure.persistence.entity.ProductoEntity;

@Component
public class ProductoJpaMapper {
	public Producto entityToDomain(ProductoEntity entity) {
		return new Producto(entity.getId(),
				entity.getNombre(),
				entity.getPrecio(),
				entity.getCantidadEnStock());
		
	}
	
	public ProductoEntity domainToEntity(Producto domain) {
		ProductoEntity entity= new ProductoEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		entity.setPrecio(domain.getPrecio());
		entity.setCantidadEnStock(domain.getCantidadEnStock());
		
		return entity;
	}
}
