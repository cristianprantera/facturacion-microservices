package com.facturacion.facturacion.infrastructure.rest.dto;

import java.math.BigDecimal;

public class DetalleFacturaResponseDTO {

    private String productoNombre;
    private Long cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public String getProductoNombre() { return productoNombre; }
    public Long getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }

    public void setProductoNombre(String productoNombre) { this.productoNombre = productoNombre; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
