package com.facturacion.sucursales.application;

import org.springframework.stereotype.Service;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.in.EditarSucursalUseCase;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;
@Service
public class EditarSucursalUseCaseImpl implements EditarSucursalUseCase{
	private final SucursalRepositoryPort repo;

	public EditarSucursalUseCaseImpl(SucursalRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public Sucursal editarSucursalPorId(Long id, Sucursal sucursal) {
		Sucursal existing=repo.obtenerPorId(id)
				.orElseThrow();
		existing.setNombre(sucursal.getNombre());
		existing.setDireccion(sucursal.getDireccion());
		Sucursal updated=repo.actualizar(existing);
		return updated;
				
	}
	
	
}
