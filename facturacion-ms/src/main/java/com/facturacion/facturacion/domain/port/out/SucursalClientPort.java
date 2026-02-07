package com.facturacion.facturacion.domain.port.out;

import com.facturacion.facturacion.infrastructure.client.dto.SucursalDTO;

public interface SucursalClientPort {
    SucursalDTO obtenerPorId(Long idSucursal);
}
