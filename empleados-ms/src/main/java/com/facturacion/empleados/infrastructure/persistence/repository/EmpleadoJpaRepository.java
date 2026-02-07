package com.facturacion.empleados.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.empleados.infrastructure.persistence.entity.EmpleadoEntity;

@Repository
public interface EmpleadoJpaRepository extends JpaRepository<EmpleadoEntity,Long> {

}
