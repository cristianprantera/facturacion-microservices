package com.facturacion.empleados.domain.port.in;

import com.facturacion.empleados.domain.model.Empleado;

public interface CrearEmpleadoUseCase {
	Empleado crearEmpleado(Empleado empleado);
}
