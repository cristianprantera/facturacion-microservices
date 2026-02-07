package com.facturacion.empleados.infrastructure.rest.controller;

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

import com.facturacion.empleados.domain.model.Empleado;
import com.facturacion.empleados.domain.port.in.CrearEmpleadoUseCase;
import com.facturacion.empleados.domain.port.in.EditarEmpleadoUseCase;
import com.facturacion.empleados.domain.port.in.EliminarEmpleadoUseCase;
import com.facturacion.empleados.domain.port.in.ListarEmpleadosUseCase;
import com.facturacion.empleados.domain.port.in.ObtenerEmpleadosUseCase;
import com.facturacion.empleados.infrastructure.rest.dto.EmpleadoRequestDTO;
import com.facturacion.empleados.infrastructure.rest.dto.EmpleadoResponseDTO;
import com.facturacion.empleados.infrastructure.rest.mapper.EmpleadoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    private final CrearEmpleadoUseCase crearUC;
    private final EditarEmpleadoUseCase editarUC;
    private final EliminarEmpleadoUseCase eliminarUC;
    private final ListarEmpleadosUseCase listarUC;
    private final ObtenerEmpleadosUseCase obtenerUC;
    private final EmpleadoDTOMapper mapper;

    public EmpleadoController(
            CrearEmpleadoUseCase crearUC,
            EditarEmpleadoUseCase editarUC,
            EliminarEmpleadoUseCase eliminarUC,
            ListarEmpleadosUseCase listarUC,
            ObtenerEmpleadosUseCase obtenerUC,
            EmpleadoDTOMapper mapper
    ) {
        this.crearUC = crearUC;
        this.editarUC = editarUC;
        this.eliminarUC = eliminarUC;
        this.listarUC = listarUC;
        this.obtenerUC = obtenerUC;
        this.mapper = mapper;
    }
    
    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crear(@Valid @RequestBody EmpleadoRequestDTO request){
    	Empleado empleado=mapper.requestToDomain(request);
    	Empleado created=crearUC.crearEmpleado(empleado);
    	return ResponseEntity.ok(mapper.domainToResponse(created));
    	
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizar(@Valid @RequestBody EmpleadoRequestDTO request,@PathVariable Long id){
    	Empleado empleado=mapper.requestToDomain(request);
    	Empleado updated=editarUC.editarEmpleadoPorId(id,empleado);
    	return ResponseEntity.ok(mapper.domainToResponse(updated));

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> traerPorId(@PathVariable Long id){
    	Empleado existing=obtenerUC.obtenerEmpleadoPorId(id);
    	return ResponseEntity.ok(mapper.domainToResponse(existing));
    }
    
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> traerTodos(){
    	List<Empleado> list=listarUC.listar();
    	return ResponseEntity.ok(list.stream().map(mapper::domainToResponse).toList());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
    	eliminarUC.eliminarEmpleadoPorId(id);
    	return ResponseEntity.noContent().build();  
    }
}
