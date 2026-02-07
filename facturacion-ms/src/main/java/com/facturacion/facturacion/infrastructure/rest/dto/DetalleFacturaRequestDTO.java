package com.facturacion.facturacion.infrastructure.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class DetalleFacturaRequestDTO {

    @NotNull(message = "El id del producto es obligatorio")
    private Long idProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Long cantidad;

    public Long getIdProducto() { return idProducto; }
    public Long getCantidad() { return cantidad; }

    public void setIdProducto(Long idProducto) { this.idProducto = idProducto; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
}
