package com.facturacion.facturacion.infrastructure.client.adapter;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.port.out.SucursalClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.SucursalDTO;
import com.facturacion.facturacion.infrastructure.client.feign.SucursalFeignClient;

@Component
public class SucursalClientAdapter implements SucursalClientPort {

    private final SucursalFeignClient feign;

    public SucursalClientAdapter(SucursalFeignClient feign) {
        this.feign = feign;
    }

    @Override
    public SucursalDTO obtenerPorId(Long idSucursal) {
        return feign.obtenerPorId(idSucursal);
    }
}
