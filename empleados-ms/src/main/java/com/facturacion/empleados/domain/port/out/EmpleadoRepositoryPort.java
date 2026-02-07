package com.facturacion.empleados.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.facturacion.empleados.domain.model.Empleado;

public interface EmpleadoRepositoryPort {
	Empleado guardarEmpleado(Empleado empleado);
	Empleado actualizarEmpleado(Empleado empleado);
	void eliminarEmpleadoPorId(Long id);
	Optional<Empleado> traerEmpleadoPorId(Long id);
	List<Empleado> listarEmpleados();
}
