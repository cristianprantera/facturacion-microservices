package com.facturacion.facturacion.domain.model;

import java.math.BigDecimal;

public class DetalleFactura {

    private Long id;
    private Long idFactura;

    private Long idProducto;
    private String productoNombre; // snapshot para que quede histórico
    private Long cantidad;
    private BigDecimal precioUnitario; // snapshot
    private BigDecimal subtotal;

    public DetalleFactura(Long id, Long idFactura, Long idProducto, String productoNombre,
                          Long cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.productoNombre = productoNombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public DetalleFactura(Long idFactura, Long idProducto, String productoNombre,
                          Long cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this(null, idFactura, idProducto, productoNombre, cantidad, precioUnitario, subtotal);
    }

    public Long getId() { return id; }
    public Long getIdFactura() { return idFactura; }
    public Long getIdProducto() { return idProducto; }
    public String getProductoNombre() { return productoNombre; }
    public Long getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }

    public void setId(Long id) { this.id = id; }
    public void setIdFactura(Long idFactura) { this.idFactura = idFactura; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public void setProductoNombre(String productoNombre) { this.productoNombre = productoNombre; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
