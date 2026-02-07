package com.facturacion.sucursales.domain.port.in;

import java.util.List;

import com.facturacion.sucursales.domain.model.Sucursal;

public interface ListarSucursalesUseCase {
	List<Sucursal> listar();
}
