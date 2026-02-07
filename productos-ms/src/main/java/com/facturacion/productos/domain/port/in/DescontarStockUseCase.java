package com.facturacion.productos.domain.port.in;

import java.util.List;

public interface DescontarStockUseCase {
    void descontar(List<StockItem> items);

    record StockItem(Long idProducto, Long cantidad) {}
}
