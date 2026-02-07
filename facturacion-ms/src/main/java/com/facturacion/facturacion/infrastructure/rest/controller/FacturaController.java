package com.facturacion.facturacion.infrastructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturacion.facturacion.domain.port.in.CrearFacturaUseCase;
import com.facturacion.facturacion.domain.port.in.ObtenerFacturaUseCase;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaRequestDTO;
import com.facturacion.facturacion.infrastructure.rest.dto.FacturaResponseDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/facturacion")
public class FacturaController {

    private final CrearFacturaUseCase crearFacturaUseCase;
    private final ObtenerFacturaUseCase obtenerFacturaUseCase;

    public FacturaController(CrearFacturaUseCase crearFacturaUseCase,
                             ObtenerFacturaUseCase obtenerFacturaUseCase) {
        this.crearFacturaUseCase = crearFacturaUseCase;
        this.obtenerFacturaUseCase = obtenerFacturaUseCase;
    }

    @PostMapping
    public ResponseEntity<FacturaResponseDTO> crear(@Valid @RequestBody FacturaRequestDTO request) {
        FacturaResponseDTO resp = crearFacturaUseCase.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaResponseDTO> obtener(@PathVariable Long id) {
        FacturaResponseDTO resp = obtenerFacturaUseCase.obtenerPorId(id);
        return ResponseEntity.ok(resp);
    }
}
