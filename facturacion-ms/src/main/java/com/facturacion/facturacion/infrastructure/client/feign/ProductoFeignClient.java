package com.facturacion.facturacion.infrastructure.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.facturacion.facturacion.infrastructure.client.dto.ProductoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.StockItemDTO;

@FeignClient(name = "productos-ms") // nombre tal cual en Eureka
public interface ProductoFeignClient {

    @GetMapping("/api/v1/productos/{id}")
    ProductoDTO obtenerPorId(@PathVariable("id") Long id);

    @PostMapping(value = "/api/v1/productos/stock/descontar", consumes = MediaType.APPLICATION_JSON_VALUE)
    void descontarStock(@RequestBody List<StockItemDTO> items);
}
