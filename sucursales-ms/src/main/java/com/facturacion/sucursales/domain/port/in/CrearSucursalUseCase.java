package com.facturacion.sucursales.domain.port.in;

import com.facturacion.sucursales.domain.model.Sucursal;

public interface CrearSucursalUseCase {
	Sucursal crearSucursal(Sucursal sucursal);
}
