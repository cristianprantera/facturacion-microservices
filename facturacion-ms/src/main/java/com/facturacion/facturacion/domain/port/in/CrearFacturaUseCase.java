package com.facturacion.facturacion.domain.port.in;

import com.facturacion.facturacion.infrastructure.rest.dto.FacturaRequestDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaResponseDTO;

public interface CrearFacturaUseCase {
    FacturaResponseDTO crear(FacturaRequestDTO request);
}
