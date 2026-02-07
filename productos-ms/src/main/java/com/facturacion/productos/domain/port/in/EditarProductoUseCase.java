package com.facturacion.productos.domain.port.in;

import com.facturacion.productos.domain.model.Producto;

public interface EditarProductoUseCase {
    Producto editar(Long id, Producto producto);
}
