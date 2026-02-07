package com.facturacion.facturacion.domain.port.out;

import java.util.List;

import com.facturacion.facturacion.infrastructure.client.dto.ProductoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.StockItemDTO;

public interface ProductoClientPort {
    ProductoDTO obtenerPorId(Long idProducto);

    // Descontar stock en productos-ms (idealmente atómico allá)
    void descontarStock(List<StockItemDTO> items);
}
