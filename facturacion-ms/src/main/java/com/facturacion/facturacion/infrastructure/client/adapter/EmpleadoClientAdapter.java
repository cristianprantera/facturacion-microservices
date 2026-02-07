package com.facturacion.facturacion.infrastructure.client.adapter;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.port.out.EmpleadoClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.EmpleadoDTO;
import com.facturacion.facturacion.infrastructure.client.feign.EmpleadoFeignClient;

@Component
public class EmpleadoClientAdapter implements EmpleadoClientPort {

    private final EmpleadoFeignClient feign;

    public EmpleadoClientAdapter(EmpleadoFeignClient feign) {
        this.feign = feign;
    }

    @Override
    public EmpleadoDTO obtenerPorId(Long idEmpleado) {
        return feign.obtenerPorId(idEmpleado);
    }
}
