package com.facturacion.clientes.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.clientes.infrastructure.persistence.entity.ClienteEntity;

@Repository
public interface ClienteJpaRepository extends JpaRepository <ClienteEntity,Long> {

}
