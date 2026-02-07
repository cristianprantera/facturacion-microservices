package com.facturacion.facturacion.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.facturacion.domain.exception.BusinessException;
import com.facturacion.facturacion.domain.exception.NotFoundException;
import com.facturacion.facturacion.domain.model.DetalleFactura;
import com.facturacion.facturacion.domain.model.Factura;
import com.facturacion.facturacion.domain.port.in.CrearFacturaUseCase;
import com.facturacion.facturacion.domain.port.out.ClienteClientPort;
import com.facturacion.facturacion.domain.port.out.EmpleadoClientPort;
import com.facturacion.facturacion.domain.port.out.FacturaRepositoryPort;
import com.facturacion.facturacion.domain.port.out.ProductoClientPort;
import com.facturacion.facturacion.domain.port.out.SucursalClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.ClienteDTO;
import com.facturacion.facturacion.infrastructure.client.dto.EmpleadoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.ProductoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.StockItemDTO;
import com.facturacion.facturacion.infrastructure.client.dto.SucursalDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.DetalleFacturaRequestDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.DetalleFacturaResponseDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaRequestDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaResponseDTO;

@Service
@Transactional
public class CrearFacturaUseCaseImpl implements CrearFacturaUseCase {

    private final ClienteClientPort clienteClient;
    private final EmpleadoClientPort empleadoClient;
    private final SucursalClientPort sucursalClient;
    private final ProductoClientPort productoClient;
    private final FacturaRepositoryPort facturaRepository;

    public CrearFacturaUseCaseImpl(ClienteClientPort clienteClient,
                                   EmpleadoClientPort empleadoClient,
                                   SucursalClientPort sucursalClient,
                                   ProductoClientPort productoClient,
                                   FacturaRepositoryPort facturaRepository) {
        this.clienteClient = clienteClient;
        this.empleadoClient = empleadoClient;
        this.sucursalClient = sucursalClient;
        this.productoClient = productoClient;
        this.facturaRepository = facturaRepository;
    }

    @Override
    public FacturaResponseDTO crear(FacturaRequestDTO request) {
        validarRequest(request);

        // 1) Validar existencia “referencias” (otros MS)
        ClienteDTO cliente = clienteClient.obtenerPorId(request.getIdCliente());
        if (cliente == null) throw new NotFoundException("Cliente " + request.getIdCliente() + " no encontrado");

        EmpleadoDTO empleado = empleadoClient.obtenerPorId(request.getIdEmpleado());
        if (empleado == null) throw new NotFoundException("Empleado " + request.getIdEmpleado() + " no encontrado");

        SucursalDTO sucursal = sucursalClient.obtenerPorId(request.getIdSucursal());
        if (sucursal == null) throw new NotFoundException("Sucursal " + request.getIdSucursal() + " no encontrada");

        // 2) Armar detalles consultando productos-ms (precio/stock)
        List<DetalleFactura> detalles = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        List<StockItemDTO> descuentoStock = new ArrayList<>();

        for (DetalleFacturaRequestDTO item : request.getDetalles()) {
            ProductoDTO producto = productoClient.obtenerPorId(item.getIdProducto());
            if (producto == null) {
                throw new NotFoundException("Producto " + item.getIdProducto() + " no encontrado");
            }

            if (producto.getCantidadEnStock() == null || producto.getCantidadEnStock() <= 0) {
                throw new BusinessException("No hay stock de: " + producto.getNombre());
            }
            if (producto.getCantidadEnStock() < item.getCantidad()) {
                throw new BusinessException("Stock insuficiente de: " + producto.getNombre());
            }

            BigDecimal precio = producto.getPrecio();
            BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(item.getCantidad()));
            total = total.add(subtotal);

            // idFactura todavía null (se completa luego de guardar)
            DetalleFactura detalle = new DetalleFactura(
                    null,
                    item.getIdProducto(),
                    producto.getNombre(),
                    item.getCantidad(),
                    precio,
                    subtotal
            );
            detalles.add(detalle);

            descuentoStock.add(new StockItemDTO(item.getIdProducto(), item.getCantidad()));
        }

        // 3) Crear y persistir factura + detalles
        Factura factura = new Factura(LocalDateTime.now(), request.getIdSucursal(), request.getIdCliente(), request.getIdEmpleado(), total);
        Factura guardada = facturaRepository.guardarFacturaConDetalles(factura, detalles);

        // 4) Descontar stock en productos-ms (después de persistir)
        //    En un sistema real: esto idealmente es “saga / outbox / evento”, pero para tu MVP sirve.
        productoClient.descontarStock(descuentoStock);

        // 5) Armar response
        return armarResponse(guardada, detalles, cliente, empleado, sucursal);
    }

    private void validarRequest(FacturaRequestDTO request) {
        if (request.getDetalles() == null || request.getDetalles().isEmpty()) {
            throw new BusinessException("La factura debe tener al menos un detalle.");
        }
    }

    private FacturaResponseDTO armarResponse(Factura factura,
                                            List<DetalleFactura> detalles,
                                            ClienteDTO cliente,
                                            EmpleadoDTO empleado,
                                            SucursalDTO sucursal) {

        BigDecimal subtotal = factura.getTotal();
        BigDecimal ivaPorcentaje = null;
        BigDecimal ivaMonto = null;
        BigDecimal totalFinal = subtotal;

        // Regla similar a tu monolito
        if ("RESPONSABLE_INSCRIPTO".equalsIgnoreCase(cliente.getTipoResponsabilidadFiscal())) {
            ivaPorcentaje = new BigDecimal("0.21");
            BigDecimal subtotalSinIva = subtotal.divide(BigDecimal.valueOf(1.21), 2, RoundingMode.HALF_UP);
            ivaMonto = subtotal.subtract(subtotalSinIva);
            totalFinal = subtotal;
        }

        FacturaResponseDTO resp = new FacturaResponseDTO();
        resp.setIdFactura(factura.getId());
        resp.setFecha(factura.getFechaHora().toLocalDate());
        resp.setHora(factura.getFechaHora().toLocalTime());

        resp.setSubtotal(subtotal);
        resp.setIvaPorcentaje(ivaPorcentaje);
        resp.setIvaMonto(ivaMonto);
        resp.setTotalFinal(totalFinal);

        resp.setClienteNombre(cliente.getNombreCompleto());
        resp.setClienteResponsabilidadFiscal(cliente.getTipoResponsabilidadFiscal());

        resp.setEmpleadoNombre(empleado.getNombreCompleto());
        resp.setEmpleadoLegajo(empleado.getLegajo());

        resp.setSucursalNombre(sucursal.getNombre());

        List<DetalleFacturaResponseDTO> detResp = new ArrayList<>();
        for (DetalleFactura d : detalles) {
            DetalleFacturaResponseDTO dto = new DetalleFacturaResponseDTO();
            dto.setProductoNombre(d.getProductoNombre());
            dto.setCantidad(d.getCantidad());
            dto.setPrecioUnitario(d.getPrecioUnitario());
            dto.setSubtotal(d.getSubtotal());
            detResp.add(dto);
        }
        resp.setDetalles(detResp);

        return resp;
    }
}
