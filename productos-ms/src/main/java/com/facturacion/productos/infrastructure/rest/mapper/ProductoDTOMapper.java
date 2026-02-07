package com.facturacion.productos.infrastructure.rest.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.infrastructure.rest.dto.ProductoRequestDTO;
import com.facturacion.productos.infrastructure.rest.dto.ProductoResponseDTO;

@Component
public class ProductoDTOMapper {
    
    public Producto requestToDomain(ProductoRequestDTO request) {
        return new Producto(
            request.getNombre(),
            request.getPrecio(),
            request.getCantidadEnStock()
        );
    }
    
    public ProductoResponseDTO domainToResponse(Producto domain) {
        ProductoResponseDTO response = new ProductoResponseDTO();
        response.setId(domain.getId()); 
        response.setNombre(domain.getNombre());
        response.setPrecio(domain.getPrecio());
        response.setCantidadEnStock(domain.getCantidadEnStock());
        return response;
    }
}

