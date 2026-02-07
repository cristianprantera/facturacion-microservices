package com.facturacion.sucursales.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.sucursales.infrastructure.persistence.entity.SucursalEntity;

@Repository
public interface SucursalJpaRepository extends JpaRepository<SucursalEntity,Long> {

}
