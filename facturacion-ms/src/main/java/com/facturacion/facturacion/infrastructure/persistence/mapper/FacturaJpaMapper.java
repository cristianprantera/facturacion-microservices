package com.facturacion.facturacion.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.model.DetalleFactura;
import com.facturacion.facturacion.domain.model.Factura;
import com.facturacion.facturacion.infrastructure.persistence.entity.DetalleFacturaEntity;
import com.facturacion.facturacion.infrastructure.persistence.entity.FacturaEntity;

@Component
public class FacturaJpaMapper {

    public FacturaEntity domainToEntity(Factura domain) {
        FacturaEntity e = new FacturaEntity();
        e.setId(domain.getId());
        e.setFechaHora(domain.getFechaHora());
        e.setIdSucursal(domain.getIdSucursal());
        e.setIdCliente(domain.getIdCliente());
        e.setIdEmpleado(domain.getIdEmpleado());
        e.setTotal(domain.getTotal());
        return e;
    }

    public Factura entityToDomain(FacturaEntity entity) {
        return new Factura(
                entity.getId(),
                entity.getFechaHora(),
                entity.getIdSucursal(),
                entity.getIdCliente(),
                entity.getIdEmpleado(),
                entity.getTotal()
        );
    }

    public DetalleFacturaEntity domainToEntityDetalle(DetalleFactura domain, FacturaEntity facturaEntity) {
        DetalleFacturaEntity e = new DetalleFacturaEntity();
        e.setId(domain.getId());
        e.setFactura(facturaEntity);
        e.setIdProducto(domain.getIdProducto());
        e.setProductoNombre(domain.getProductoNombre());
        e.setCantidad(domain.getCantidad());
        e.setPrecioUnitario(domain.getPrecioUnitario());
        e.setSubtotal(domain.getSubtotal());
        return e;
    }

    public DetalleFactura entityToDomainDetalle(DetalleFacturaEntity entity) {
        Long facturaId = entity.getFactura() != null ? entity.getFactura().getId() : null;
        return new DetalleFactura(
                entity.getId(),
                facturaId,
                entity.getIdProducto(),
                entity.getProductoNombre(),
                entity.getCantidad(),
                entity.getPrecioUnitario(),
                entity.getSubtotal()
        );
    }
}
