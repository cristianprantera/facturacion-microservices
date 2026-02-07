package com.facturacion.facturacion.domain.port.in;

import com.facturacion.facturacion.infrastructure.rest.dto.FacturaResponseDTO;

public interface ObtenerFacturaUseCase {
    FacturaResponseDTO obtenerPorId(Long idFactura);
}
