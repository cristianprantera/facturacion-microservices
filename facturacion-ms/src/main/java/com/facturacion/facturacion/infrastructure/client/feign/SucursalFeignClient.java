package com.facturacion.facturacion.infrastructure.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.facturacion.facturacion.infrastructure.client.dto.SucursalDTO;

@FeignClient(name = "sucursales-ms")
public interface SucursalFeignClient {

    @GetMapping("/api/v1/sucursales/{id}")
    SucursalDTO obtenerPorId(@PathVariable("id") Long id);
}
