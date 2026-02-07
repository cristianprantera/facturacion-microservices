package com.facturacion.sucursales.application;

import org.springframework.stereotype.Service;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.in.CrearSucursalUseCase;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;

@Service
public class CrearSucursalUseCaseImpl implements CrearSucursalUseCase {
	private final SucursalRepositoryPort repo;

	public CrearSucursalUseCaseImpl(SucursalRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Sucursal crearSucursal(Sucursal sucursal) {
		return repo.guardar(sucursal);
	}
	
	
}
