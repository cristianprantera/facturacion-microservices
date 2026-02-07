package com.facturacion.facturacion.infrastructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class FacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHora;

    @Column(nullable = false)
    private Long idSucursal;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private Long idEmpleado;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal total;

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
