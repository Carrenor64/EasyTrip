package com.example.demo.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(long id) {
        super("No se puede encontrar un usuario con el ID: " + id);
    }
}
