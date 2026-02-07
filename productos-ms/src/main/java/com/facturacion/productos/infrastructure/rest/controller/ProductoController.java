package com.facturacion.productos.infrastructure.rest.controller;

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

import com.facturacion.productos.domain.model.Producto;
import com.facturacion.productos.domain.port.in.CrearProductoUseCase;
import com.facturacion.productos.domain.port.in.DescontarStockUseCase;
import com.facturacion.productos.domain.port.in.EditarProductoUseCase;
import com.facturacion.productos.domain.port.in.EliminarProductoUseCase;
import com.facturacion.productos.domain.port.in.ListarProductosUseCase;
import com.facturacion.productos.domain.port.in.ObtenerProductoUseCase;
import com.facturacion.productos.infrastructure.rest.dto.ProductoRequestDTO;
import com.facturacion.productos.infrastructure.rest.dto.ProductoResponseDTO;
import com.facturacion.productos.infrastructure.rest.dto.StockItemRequestDTO;
import com.facturacion.productos.infrastructure.rest.mapper.ProductoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductoController {
	private final CrearProductoUseCase crearUC;
	private final EditarProductoUseCase editarUC;
	private final EliminarProductoUseCase eliminarUC;
	private final ListarProductosUseCase listarUC;
	private final ObtenerProductoUseCase obtenerUC;
	private final ProductoDTOMapper mapper;
	private final DescontarStockUseCase descontarStockUC;

	
	
	public ProductoController(CrearProductoUseCase crearUC, EditarProductoUseCase editarUC,
			EliminarProductoUseCase eliminarUC, ListarProductosUseCase listarUC, ObtenerProductoUseCase obtenerUC, ProductoDTOMapper mapper,DescontarStockUseCase descontarStockUC) {
		this.crearUC = crearUC;
		this.editarUC = editarUC;
		this.eliminarUC = eliminarUC;
		this.listarUC = listarUC;
		this.obtenerUC = obtenerUC;
		this.mapper = mapper;
	    this.descontarStockUC = descontarStockUC;

	}
	
	@PostMapping
	public ResponseEntity<ProductoResponseDTO> crear(@RequestBody ProductoRequestDTO request){
		Producto domain=mapper.requestToDomain(request);
		Producto created= crearUC.crear(domain);		
		return ResponseEntity.ok(mapper.domainToResponse(created));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoResponseDTO> editar(@PathVariable Long id,@RequestBody ProductoRequestDTO request){
		Producto domain=mapper.requestToDomain(request);
		Producto edited=editarUC.editar(id, domain);	
		return ResponseEntity.ok(mapper.domainToResponse(edited));		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id){
		Producto existing=obtenerUC.obtenerPorId(id);		
		return ResponseEntity.ok(mapper.domainToResponse(existing));		

	}
	
	@GetMapping
	public ResponseEntity<List<ProductoResponseDTO>> listar(){
        List<Producto> productos = listarUC.listar();
        return ResponseEntity.ok(productos.stream().map(mapper::domainToResponse).toList());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		eliminarUC.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/stock/descontar")
	public ResponseEntity<Void> descontarStock(@RequestBody @Valid List<StockItemRequestDTO> items) {

	    List<DescontarStockUseCase.StockItem> domainItems = items.stream()
	            .map(i -> new DescontarStockUseCase.StockItem(i.getIdProducto(), i.getCantidad()))
	            .toList();

	    descontarStockUC.descontar(domainItems);
	    return ResponseEntity.noContent().build();
	}

}
