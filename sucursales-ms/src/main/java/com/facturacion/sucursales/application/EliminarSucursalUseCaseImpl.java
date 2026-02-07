package com.facturacion.sucursales.application;

import org.springframework.stereotype.Service;

import com.facturacion.sucursales.domain.port.in.EliminarSucursalUseCase;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;

@Service
public class EliminarSucursalUseCaseImpl implements EliminarSucursalUseCase {
	private final SucursalRepositoryPort repo;

	public EliminarSucursalUseCaseImpl(SucursalRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public void eliminarSucursalPorId(Long id) {
		repo.eliminar(id);
	}
	
	
}
