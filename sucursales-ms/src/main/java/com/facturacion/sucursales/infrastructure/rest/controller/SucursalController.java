package com.facturacion.sucursales.infrastructure.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.sucursales.domain.model.Sucursal;
import com.facturacion.sucursales.domain.port.in.CrearSucursalUseCase;
import com.facturacion.sucursales.domain.port.in.EditarSucursalUseCase;
import com.facturacion.sucursales.domain.port.in.EliminarSucursalUseCase;
import com.facturacion.sucursales.domain.port.in.ListarSucursalesUseCase;
import com.facturacion.sucursales.domain.port.in.ObtenerSucursalUseCase;
import com.facturacion.sucursales.infrastructure.rest.dto.SucursalRequestDTO;
import com.facturacion.sucursales.infrastructure.rest.dto.SucursalResponseDTO;
import com.facturacion.sucursales.infrastructure.rest.mapper.SucursalDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {
	private final CrearSucursalUseCase crearUC;
	private final EditarSucursalUseCase editarUC;
	private final EliminarSucursalUseCase eliminarUC;
	private final ListarSucursalesUseCase listarUC;
	private final ObtenerSucursalUseCase obtenerUC;
	private final SucursalDtoMapper mapper;
	
	public SucursalController(CrearSucursalUseCase crearUC, EditarSucursalUseCase editarUC,
			EliminarSucursalUseCase eliminarUC, ListarSucursalesUseCase listarUC, ObtenerSucursalUseCase obtenerUC,
			SucursalDtoMapper mapper) {
		super();
		this.crearUC = crearUC;
		this.editarUC = editarUC;
		this.eliminarUC = eliminarUC;
		this.listarUC = listarUC;
		this.obtenerUC = obtenerUC;
		this.mapper = mapper;
	}
	
	@PostMapping
	public ResponseEntity<SucursalResponseDTO> crearSucursal(@Valid @RequestBody SucursalRequestDTO request){
		Sucursal domain=mapper.requestToDomain(request);
		Sucursal created=crearUC.crearSucursal(domain);
		return ResponseEntity.ok(mapper.domainToResponse(created));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SucursalResponseDTO> actualizar(@Valid @RequestBody SucursalRequestDTO request, @PathVariable Long id){
		Sucursal domain=mapper.requestToDomain(request);
		Sucursal updated=editarUC.editarSucursalPorId(id,domain);
		return ResponseEntity.ok(mapper.domainToResponse(updated));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SucursalResponseDTO> traerPorId(@PathVariable Long id){
		Sucursal existing=obtenerUC.obtenerSucursalPorId(id);
		return ResponseEntity.ok(mapper.domainToResponse(existing));
	}
	
	@GetMapping
	public ResponseEntity<List<SucursalResponseDTO>> listar(){
		return ResponseEntity.ok(
				listarUC.listar()
				.stream()
				.map(mapper::domainToResponse)
				.toList());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		eliminarUC.eliminarSucursalPorId(id);
		return ResponseEntity.noContent().build();
	}

}
