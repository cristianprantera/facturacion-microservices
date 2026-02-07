package com.facturacion.facturacion.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.facturacion.infrastructure.persistence.entity.DetalleFacturaEntity;

public interface DetalleFacturaJpaRepository extends JpaRepository<DetalleFacturaEntity, Long> {
    List<DetalleFacturaEntity> findByFacturaId(Long facturaId);
}
