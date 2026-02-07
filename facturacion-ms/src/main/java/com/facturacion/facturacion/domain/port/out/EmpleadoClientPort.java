package com.facturacion.facturacion.domain.port.out;

import com.facturacion.facturacion.infrastructure.client.dto.EmpleadoDTO;

public interface EmpleadoClientPort {
    EmpleadoDTO obtenerPorId(Long idEmpleado);
}
