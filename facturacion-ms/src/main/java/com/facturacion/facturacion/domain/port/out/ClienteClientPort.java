package com.facturacion.facturacion.domain.port.out;

import com.facturacion.facturacion.infrastructure.client.dto.ClienteDTO;

public interface ClienteClientPort {
    ClienteDTO obtenerPorId(Long idCliente);
}
