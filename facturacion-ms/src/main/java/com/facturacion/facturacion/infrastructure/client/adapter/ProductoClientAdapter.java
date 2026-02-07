package com.facturacion.facturacion.infrastructure.client.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.port.out.ProductoClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.ProductoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.StockItemDTO;
import com.facturacion.facturacion.infrastructure.client.feign.ProductoFeignClient;

@Component
public class ProductoClientAdapter implements ProductoClientPort {

    private final ProductoFeignClient feign;

    public ProductoClientAdapter(ProductoFeignClient feign) {
        this.feign = feign;
    }

    @Override
    public ProductoDTO obtenerPorId(Long idProducto) {
        return feign.obtenerPorId(idProducto);
    }

    @Override
    public void descontarStock(List<StockItemDTO> items) {
        feign.descontarStock(items);
    }
}
