package com.facturacion.facturacion.infrastructure.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_factura")
public class DetalleFacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación SOLO con FacturaEntity (mismo MS, misma DB)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private FacturaEntity factura;

    @Column(nullable = false)
    private Long idProducto;

    @Column(nullable = false)
    private String productoNombre;

    @Column(nullable = false)
    private Long cantidad;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal subtotal;

    public Long getId() { return id; }
    public FacturaEntity getFactura() { return factura; }
    public Long getIdProducto() { return idProducto; }
    public String getProductoNombre() { return productoNombre; }
    public Long getCantidad() { return cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }

    public void setId(Long id) { this.id = id; }
    public void setFactura(FacturaEntity factura) { this.factura = factura; }
    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public void setProductoNombre(String productoNombre) { this.productoNombre = productoNombre; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
