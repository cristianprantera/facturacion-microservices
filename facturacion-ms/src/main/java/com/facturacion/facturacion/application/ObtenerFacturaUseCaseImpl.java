package com.facturacion.facturacion.application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.facturacion.domain.exception.NotFoundException;
import com.facturacion.facturacion.domain.model.DetalleFactura;
import com.facturacion.facturacion.domain.model.Factura;
import com.facturacion.facturacion.domain.port.in.ObtenerFacturaUseCase;
import com.facturacion.facturacion.domain.port.out.ClienteClientPort;
import com.facturacion.facturacion.domain.port.out.EmpleadoClientPort;
import com.facturacion.facturacion.domain.port.out.FacturaRepositoryPort;
import com.facturacion.facturacion.domain.port.out.SucursalClientPort;
import com.facturacion.facturacion.infrastructure.client.dto.ClienteDTO;
import com.facturacion.facturacion.infrastructure.client.dto.EmpleadoDTO;
import com.facturacion.facturacion.infrastructure.client.dto.SucursalDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.DetalleFacturaResponseDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaResponseDTO;

@Service
@Transactional(readOnly = true)
public class ObtenerFacturaUseCaseImpl implements ObtenerFacturaUseCase {

    private final FacturaRepositoryPort facturaRepository;
    private final ClienteClientPort clienteClient;
    private final EmpleadoClientPort empleadoClient;
    private final SucursalClientPort sucursalClient;

    public ObtenerFacturaUseCaseImpl(FacturaRepositoryPort facturaRepository,
                                     ClienteClientPort clienteClient,
                                     EmpleadoClientPort empleadoClient,
                                     SucursalClientPort sucursalClient) {
        this.facturaRepository = facturaRepository;
        this.clienteClient = clienteClient;
        this.empleadoClient = empleadoClient;
        this.sucursalClient = sucursalClient;
    }

    @Override
    public FacturaResponseDTO obtenerPorId(Long idFactura) {
        Factura factura = facturaRepository.buscarFacturaPorId(idFactura)
                .orElseThrow(() -> new NotFoundException("Factura " + idFactura + " no encontrada"));

        List<DetalleFactura> detalles = facturaRepository.buscarDetallesPorFacturaId(idFactura);

        ClienteDTO cliente = clienteClient.obtenerPorId(factura.getIdCliente());
        EmpleadoDTO empleado = empleadoClient.obtenerPorId(factura.getIdEmpleado());
        SucursalDTO sucursal = sucursalClient.obtenerPorId(factura.getIdSucursal());

        return armarResponse(factura, detalles, cliente, empleado, sucursal);
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

        if (cliente != null && "RESPONSABLE_INSCRIPTO".equalsIgnoreCase(cliente.getTipoResponsabilidadFiscal())) {
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

        if (cliente != null) {
            resp.setClienteNombre(cliente.getNombreCompleto());
            resp.setClienteResponsabilidadFiscal(cliente.getTipoResponsabilidadFiscal());
        }
        if (empleado != null) {
            resp.setEmpleadoNombre(empleado.getNombreCompleto());
            resp.setEmpleadoLegajo(empleado.getLegajo());
        }
        if (sucursal != null) {
            resp.setSucursalNombre(sucursal.getNombre());
        }

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
