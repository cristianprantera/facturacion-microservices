package com.facturacion.sucursales.domain.port.in;

import com.facturacion.sucursales.domain.model.Sucursal;

public interface EditarSucursalUseCase {
	Sucursal editarSucursalPorId(Long id, Sucursal sucursal);
}
