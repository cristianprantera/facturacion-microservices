package com.facturacion.facturacion.infrastructure.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.facturacion.facturacion.infrastructure.client.dto.EmpleadoDTO;

@FeignClient(name = "empleados-ms")
public interface EmpleadoFeignClient {

    @GetMapping("/api/v1/empleados/{id}")
    EmpleadoDTO obtenerPorId(@PathVariable("id") Long id);
}
