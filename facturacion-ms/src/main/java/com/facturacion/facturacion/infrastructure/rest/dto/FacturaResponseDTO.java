package com.facturacion.facturacion.infrastructure.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FacturaResponseDTO {

    private Long idFactura;
    private LocalDate fecha;
    private LocalTime hora;

    private BigDecimal subtotal;
    private BigDecimal ivaPorcentaje;
    private BigDecimal ivaMonto;
    private BigDecimal totalFinal;

    private String clienteNombre;
    private String clienteResponsabilidadFiscal;
    private String empleadoNombre;
    private String empleadoLegajo;
    private String sucursalNombre;

    private List<DetalleFacturaResponseDTO> detalles;

    public Long getIdFactura() { return idFactura; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public BigDecimal getSubtotal() { return subtotal; }
    public BigDecimal getIvaPorcentaje() { return ivaPorcentaje; }
    public BigDecimal getIvaMonto() { return ivaMonto; }
    public BigDecimal getTotalFinal() { return totalFinal; }
    public String getClienteNombre() { return clienteNombre; }
    public String getClienteResponsabilidadFiscal() { return clienteResponsabilidadFiscal; }
    public String getEmpleadoNombre() { return empleadoNombre; }
    public String getEmpleadoLegajo() { return empleadoLegajo; }
    public String getSucursalNombre() { return sucursalNombre; }
    public List<DetalleFacturaResponseDTO> getDetalles() { return detalles; }

    public void setIdFactura(Long idFactura) { this.idFactura = idFactura; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public void setIvaPorcentaje(BigDecimal ivaPorcentaje) { this.ivaPorcentaje = ivaPorcentaje; }
    public void setIvaMonto(BigDecimal ivaMonto) { this.ivaMonto = ivaMonto; }
    public void setTotalFinal(BigDecimal totalFinal) { this.totalFinal = totalFinal; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }
    public void setClienteResponsabilidadFiscal(String clienteResponsabilidadFiscal) { this.clienteResponsabilidadFiscal = clienteResponsabilidadFiscal; }
    public void setEmpleadoNombre(String empleadoNombre) { this.empleadoNombre = empleadoNombre; }
    public void setEmpleadoLegajo(String empleadoLegajo) { this.empleadoLegajo = empleadoLegajo; }
    public void setSucursalNombre(String sucursalNombre) { this.sucursalNombre = sucursalNombre; }
    public void setDetalles(List<DetalleFacturaResponseDTO> detalles) { this.detalles = detalles; }
}
