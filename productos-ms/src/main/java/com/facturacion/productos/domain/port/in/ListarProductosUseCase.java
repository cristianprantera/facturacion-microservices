package com.facturacion.productos.domain.port.in;


import java.util.List;

import com.facturacion.productos.domain.model.Producto;

public interface ListarProductosUseCase {
    List<Producto> listar();
}
