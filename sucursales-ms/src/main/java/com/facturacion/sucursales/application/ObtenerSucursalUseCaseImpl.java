package com.facturacion.sucursales.application;

import org.springframework.stereotype.Service;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.in.ObtenerSucursalUseCase;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;

@Service
public class ObtenerSucursalUseCaseImpl implements ObtenerSucursalUseCase{
	private final SucursalRepositoryPort repo;

	public ObtenerSucursalUseCaseImpl(SucursalRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Sucursal obtenerSucursalPorId(Long id) {
		return repo.obtenerPorId(id).orElseThrow();
	}
	
	

}
