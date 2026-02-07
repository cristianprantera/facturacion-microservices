package com.facturacion.sucursales.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.infrastructure.persistence.entity.SucursalEntity;

@Component
public class SucursalJpaMapper {
	
	public Sucursal entityToDomain(SucursalEntity entity) {
		return new Sucursal(entity.getId(),
				entity.getNombre(),
				entity.getDireccion());
	}
	
	public SucursalEntity domainToEntity(Sucursal domain) {
		SucursalEntity entity=new SucursalEntity();
		entity.setId(domain.getId());
		entity.setNombre(domain.getNombre());
		entity.setDireccion(domain.getDireccion());		
		return entity;
	}
}
