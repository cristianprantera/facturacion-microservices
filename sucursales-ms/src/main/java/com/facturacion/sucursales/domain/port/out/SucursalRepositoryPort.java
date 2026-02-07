package com.facturacion.sucursales.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.facturacion.sucursales.domain.model.Sucursal;

public interface SucursalRepositoryPort {
	Sucursal guardar(Sucursal sucursal);
	Sucursal actualizar (Sucursal sucursal);
	List<Sucursal> listar();
	void eliminar(Long id);
	Optional<Sucursal> obtenerPorId(Long id);
}
