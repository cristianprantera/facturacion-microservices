package com.facturacion.facturacion.infrastructure.persistence.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.facturacion.facturacion.domain.model.DetalleFactura;
import com.facturacion.facturacion.domain.model.Factura;
import com.facturacion.facturacion.domain.port.out.FacturaRepositoryPort;
import com.facturacion.facturacion.infrastructure.persistence.entity.DetalleFacturaEntity;
import com.facturacion.facturacion.infrastructure.persistence.entity.FacturaEntity;
import com.facturacion.facturacion.infrastructure.persistence.mapper.FacturaJpaMapper;
import com.facturacion.facturacion.infrastructure.persistence.repository.DetalleFacturaJpaRepository;
import com.facturacion.facturacion.infrastructure.persistence.repository.FacturaJpaRepository;

@Component
public class FacturaRepositoryAdapter implements FacturaRepositoryPort {

    private final FacturaJpaRepository facturaRepo;
    private final DetalleFacturaJpaRepository detalleRepo;
    private final FacturaJpaMapper mapper;

    public FacturaRepositoryAdapter(FacturaJpaRepository facturaRepo,
                                   DetalleFacturaJpaRepository detalleRepo,
                                   FacturaJpaMapper mapper) {
        this.facturaRepo = facturaRepo;
        this.detalleRepo = detalleRepo;
        this.mapper = mapper;
    }

    @Override
    public Factura guardarFacturaConDetalles(Factura factura, List<DetalleFactura> detalles) {
        // 1) Guardar factura
        FacturaEntity facturaEntity = mapper.domainToEntity(factura);
        FacturaEntity guardada = facturaRepo.save(facturaEntity);

        // 2) Guardar detalles
        List<DetalleFacturaEntity> toSave = new ArrayList<>();
        for (DetalleFactura d : detalles) {
            // completar idFactura en domain para coherencia si querés
            d.setIdFactura(guardada.getId());
            toSave.add(mapper.domainToEntityDetalle(d, guardada));
        }
        detalleRepo.saveAll(toSave);

        return mapper.entityToDomain(guardada);
    }

    @Override
    public Optional<Factura> buscarFacturaPorId(Long idFactura) {
        return facturaRepo.findById(idFactura).map(mapper::entityToDomain);
    }

    @Override
    public List<DetalleFactura> buscarDetallesPorFacturaId(Long idFactura) {
        List<DetalleFacturaEntity> entities = detalleRepo.findByFacturaId(idFactura);
        List<DetalleFactura> out = new ArrayList<>();
        for (DetalleFacturaEntity e : entities) {
            out.add(mapper.entityToDomainDetalle(e));
        }
        return out;
    }
}
