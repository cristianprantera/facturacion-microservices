package com.facturacion.productos.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.facturacion.productos.domain.model.Producto;

public interface ProductoRepositoryPort {
    Producto guardar(Producto producto);
    Optional<Producto> buscarPorId(Long id);
    void eliminar(Long id);
    List<Producto> listar();
    Producto actualizar(Producto producto);
}
