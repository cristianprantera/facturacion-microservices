package com.facturacion.facturacion.infrastructure.client.adapter;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.port.out.ClienteClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.ClienteDTO;
import com.facturacion.facturacion.infrastructure.client.feign.ClienteFeignClient;

@Component
public class ClienteClientAdapter implements ClienteClientPort {

    private final ClienteFeignClient feign;

    public ClienteClientAdapter(ClienteFeignClient feign) {
        this.feign = feign;
    }

    @Override
    public ClienteDTO obtenerPorId(Long idCliente) {
        return feign.obtenerPorId(idCliente);
    }
}
