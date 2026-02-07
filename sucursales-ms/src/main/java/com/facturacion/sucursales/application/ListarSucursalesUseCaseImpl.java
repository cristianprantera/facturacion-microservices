package com.facturacion.sucursales.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.in.ListarSucursalesUseCase;
import com.facturacion.sucursales.domain.port.out.SucursalRepositoryPort;

@Service
public class ListarSucursalesUseCaseImpl implements ListarSucursalesUseCase {
	private final SucursalRepositoryPort repo;

	public ListarSucursalesUseCaseImpl(SucursalRepositoryPort repo) {
		this.repo = repo;
	}

	@Override
	public List<Sucursal> listar() {
		return repo.listar();
	}
	

}
