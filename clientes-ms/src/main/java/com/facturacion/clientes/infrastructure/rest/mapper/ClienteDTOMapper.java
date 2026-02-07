package com.facturacion.clientes.infrastructure.rest.mapper;

import org.springframework.stereotype.Component;

import com.facturacion.clientes.domain.model.Cliente;
import com.facturacion.clientes.infrastructure.rest.dto.ClienteRequestDTO;
import com.facturacion.clientes.infrastructure.rest.dto.ClienteResponseDTO;

@Component
public class ClienteDTOMapper {
	public Cliente requestToDomain(ClienteRequestDTO request) {
		return new Cliente(request.getNombre(),
				request.getApellido(),
				request.getDni(),
				request.getNroCelular(),
				request.getEmail());
	}
	
	public ClienteResponseDTO domainToResponse(Cliente domain) {
		ClienteResponseDTO response=new ClienteResponseDTO();
		response.setId(domain.getId());
		response.setNombre(domain.getNombre());
		response.setApellido(domain.getApellido());
		response.setDni(domain.getDni());
		response.setNroCelular(domain.getNroCelular());
		response.setEmail(domain.getEmail());
		
		return response;
	}
}
