package com.facturacion.facturacion.infrastructure.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StockItemDTO {
    private Long idProducto;
    private Long cantidad;
}
