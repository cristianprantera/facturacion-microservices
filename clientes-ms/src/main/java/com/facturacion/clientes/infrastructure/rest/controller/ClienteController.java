package com.facturacion.clientes.infrastructure.rest.controller;

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

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.domain.port.in.CrearClienteUseCase;
import com.facturacion.clientes.domain.port.in.EditarClienteUseCase;
import com.facturacion.clientes.domain.port.in.EliminarClienteUseCase;
import com.facturacion.clientes.domain.port.in.ListarClientesUseCase;
import com.facturacion.clientes.domain.port.in.ObtenerClienteUseCase;
import com.facturacion.clientes.infrastructure.rest.dto.ClienteRequestDTO;
import com.facturacion.clientes.infrastructure.rest.dto.ClienteResponseDTO;
import com.facturacion.clientes.infrastructure.rest.mapper.ClienteDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    private final CrearClienteUseCase crearUC;
    private final EditarClienteUseCase editarUC;
    private final EliminarClienteUseCase eliminarUC;
    private final ListarClientesUseCase listarUC;
    private final ObtenerClienteUseCase obtenerUC;
    private final ClienteDTOMapper mapper;
    
    public ClienteController(
            CrearClienteUseCase crearUC,
            EditarClienteUseCase editarUC,
            EliminarClienteUseCase eliminarUC,
            ListarClientesUseCase listarUC,
            ObtenerClienteUseCase obtenerUC,
            ClienteDTOMapper mapper
    ) {
        this.crearUC = crearUC;
        this.editarUC = editarUC;
        this.eliminarUC = eliminarUC;
        this.listarUC = listarUC;
        this.obtenerUC = obtenerUC;
        this.mapper = mapper;
    }
    
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crear(@Valid @RequestBody ClienteRequestDTO request){
    	Cliente domain=mapper.requestToDomain(request);
    	Cliente created=crearUC.crear(domain);
    	return ResponseEntity.ok( mapper.domainToResponse(created));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> editar(@Valid @RequestBody ClienteRequestDTO request,@PathVariable Long id){
    	Cliente domain=mapper.requestToDomain(request);
    	Cliente edited=editarUC.editar(id, domain);
    	return ResponseEntity.ok( mapper.domainToResponse(edited));

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> traerPorId(@PathVariable Long id){
    	Cliente existing=obtenerUC.obtenerClientePorId(id);
    	return ResponseEntity.ok( mapper.domainToResponse(existing));
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> traerClientes(){
    	return ResponseEntity.ok(
    			listarUC.listar()
    			.stream()
    			.map(mapper::domainToResponse)
    			.toList());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
    	eliminarUC.eliminar(id);
    	return ResponseEntity.noContent().build();  
    }
}
