package com.example.demo.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Long id) {
        super("No se puede encontrar categoria con ID: " + id);
    }
}
