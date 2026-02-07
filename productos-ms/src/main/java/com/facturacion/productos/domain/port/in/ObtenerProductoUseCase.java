package com.facturacion.productos.domain.port.in;

import com.facturacion.productos.domain.model.Producto;

public interface ObtenerProductoUseCase {
    Producto obtenerPorId(Long id);
}
