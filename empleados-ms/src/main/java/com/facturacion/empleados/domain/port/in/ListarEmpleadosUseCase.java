package com.facturacion.empleados.domain.port.in;

import java.util.List;

import com.facturacion.empleados.domain.model.Empleado;

public interface ListarEmpleadosUseCase {
	List<Empleado> listar();
}
