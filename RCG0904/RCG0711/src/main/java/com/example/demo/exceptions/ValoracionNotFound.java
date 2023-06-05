package com.example.demo.exceptions;

public class ValoracionNotFound extends RuntimeException {
    public ValoracionNotFound(Long id) {
        super("No se puede encontrar valoracion con ID: " + id);
        } 
}
