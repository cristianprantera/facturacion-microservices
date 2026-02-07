package com.facturacion.productos.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.facturacion.productos.infrastructure.persistence.entity.ProductoEntity;

@Repository
public interface ProductoJpaRepository extends JpaRepository <ProductoEntity,Long>{

}
