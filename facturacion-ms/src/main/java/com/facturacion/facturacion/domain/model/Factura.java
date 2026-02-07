package com.facturacion.facturacion.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Factura {

    private Long id;
    private LocalDateTime fechaHora;

    // IDs de “otros MS” (no entidades JPA de otros dominios)
    private Long idSucursal;
    private Long idCliente;
    private Long idEmpleado;

    private BigDecimal total;

    public Factura(Long id, LocalDateTime fechaHora, Long idSucursal, Long idCliente, Long idEmpleado, BigDecimal total) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.idSucursal = idSucursal;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.total = total;
    }

    public Factura(LocalDateTime fechaHora, Long idSucursal, Long idCliente, Long idEmpleado, BigDecimal total) {
        this(null, fechaHora, idSucursal, idCliente, idEmpleado, total);
    }

    public Long getId() { return id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public Long getIdSucursal() { return idSucursal; }
    public Long getIdCliente() { return idCliente; }
    public Long getIdEmpleado() { return idEmpleado; }
    public BigDecimal getTotal() { return total; }

    public void setId(Long id) { this.id = id; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public void setIdSucursal(Long idSucursal) { this.idSucursal = idSucursal; }
    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }
    public void setIdEmpleado(Long idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
