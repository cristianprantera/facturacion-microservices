package com.facturacion.facturacion.infrastructure.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.facturacion.facturacion.infrastructure.client.dto.ClienteDTO;

@FeignClient(name = "clientes-ms")
public interface ClienteFeignClient {

    @GetMapping("/api/v1/clientes/{id}")
    ClienteDTO obtenerPorId(@PathVariable("id") Long id);
}
