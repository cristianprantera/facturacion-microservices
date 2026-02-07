package com.facturacion.empleados.domain.port.in;

import com.facturacion.empleados.domain.model.Empleado;

public interface EditarEmpleadoUseCase {
	Empleado editarEmpleadoPorId(Long id,Empleado empleado);
}
