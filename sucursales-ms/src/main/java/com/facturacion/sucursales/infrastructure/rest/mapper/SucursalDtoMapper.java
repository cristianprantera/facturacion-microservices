package com.facturacion.sucursales.infrastructure.rest.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.infrastructure.rest.dto.SucursalRequestDTO;
import com.facturacion.sucursales.infrastructure.rest.dto.SucursalResponseDTO;

@Component
public class SucursalDtoMapper {
	public Sucursal requestToDomain(SucursalRequestDTO request) {
		return new Sucursal(request.getNombre(),
				request.getDireccion());
	}
	
	public SucursalResponseDTO domainToResponse(Sucursal domain) {
		SucursalResponseDTO response=new SucursalResponseDTO();
		response.setId(domain.getId());
		response.setNombre(domain.getNombre());
		response.setDireccion(domain.getDireccion());
		return response;
	}
}
