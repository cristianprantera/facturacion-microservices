package com.facturacion.facturacion.infrastructure.client.dto;

import java.math.BigDecimal;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Long cantidadEnStock;

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }
    public Long getCantidadEnStock() { return cantidadEnStock; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public void setCantidadEnStock(Long cantidadEnStock) { this.cantidadEnStock = cantidadEnStock; }
}
