package com.facturacion.productos.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.DescontarStockUseCase;
import com.facturacion.productos.domain.port.out.ProductoRepositoryPort;

@Service
public class DescontarStockUseCaseImpl implements DescontarStockUseCase {

    private final ProductoRepositoryPort productoRepo;

    public DescontarStockUseCaseImpl(ProductoRepositoryPort productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    @Transactional
    public void descontar(List<StockItem> items) {
        // 1) validar todos antes de tocar stock (todo o nada)
        for (StockItem item : items) {
            Producto p = productoRepo.buscarPorId(item.idProducto())
                    .orElseThrow(() -> new IllegalArgumentException("Producto " + item.idProducto() + " no existe"));

            if (p.getCantidadEnStock() < item.cantidad()) {
                throw new IllegalArgumentException("Stock insuficiente para producto " + p.getNombre()
                        + " (id=" + p.getId() + "). Disponible=" + p.getCantidadEnStock()
                        + ", requerido=" + item.cantidad());
            }
        }

        // 2) si pasó validación, recién ahí descontamos
        for (StockItem item : items) {
            Producto p = productoRepo.buscarPorId(item.idProducto())
                    .orElseThrow(() -> new IllegalArgumentException("Producto " + item.idProducto() + " no existe"));

            p.setCantidadEnStock(p.getCantidadEnStock() - item.cantidad());
            productoRepo.guardar(p);
        }
    }
}
