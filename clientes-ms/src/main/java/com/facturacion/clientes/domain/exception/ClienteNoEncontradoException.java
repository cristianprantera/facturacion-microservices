package com.facturacion.clientes.domain.exception;

public class ClienteNoEncontradoException extends RuntimeException {

    public ClienteNoEncontradoException(Long id) {
        super("Cliente con id " + id + " no encontrado");
    }
}