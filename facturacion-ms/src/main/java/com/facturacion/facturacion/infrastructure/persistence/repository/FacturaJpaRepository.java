package com.facturacion.facturacion.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.facturacion.infrastructure.persistence.entity.FacturaEntity;

public interface FacturaJpaRepository extends JpaRepository<FacturaEntity, Long> {
}
