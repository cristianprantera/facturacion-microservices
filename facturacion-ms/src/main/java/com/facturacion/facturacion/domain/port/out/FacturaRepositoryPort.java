package com.facturacion.facturacion.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.facturacion.facturacion.domain.model.DetalleFactura;
import com.facturacion.facturacion.domain.model.Factura;

public interface FacturaRepositoryPort {
    Factura guardarFacturaConDetalles(Factura factura, List<DetalleFactura> detalles);
    Optional<Factura> buscarFacturaPorId(Long idFactura);
    List<DetalleFactura> buscarDetallesPorFacturaId(Long idFactura);
}
