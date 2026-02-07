package com.facturacion.facturacion.infrastructure.rest.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FacturaRequestDTO {

    @NotNull(message = "El id del cliente es obligatorio")
    private Long idCliente;

    @NotNull(message = "El id del empleado es obligatorio")
    private Long idEmpleado;

    @NotNull(message = "El id de la sucursal es obligatorio")
    private Long idSucursal;

    @NotEmpty(message = "La factura debe contener al menos un detalle")
    @Size(min = 1, message = "La factura debe contener al menos un producto")
    @Valid
    private List<DetalleFacturaRequestDTO> detalles;

    public Long getIdCliente() { return idCliente; }
    public Long getIdEmpleado() { return idEmpleado; }
    public Long getIdSucursal() { return idSucursal; }
    public List<DetalleFacturaRequestDTO> getDetalles() { return detalles; }

    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }
    public void setIdEmpleado(Long idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setIdSucursal(Long idSucursal) { this.idSucursal = idSucursal; }
    public void setDetalles(List<DetalleFacturaRequestDTO> detalles) { this.detalles = detalles; }
}
