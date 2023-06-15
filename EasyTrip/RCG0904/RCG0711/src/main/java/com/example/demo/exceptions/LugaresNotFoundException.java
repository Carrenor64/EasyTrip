package com.example.demo.exceptions;

public class LugaresNotFoundException extends RuntimeException {
    public LugaresNotFoundException(long id) {
        super("No se puede encontrar lugar con ID: " + id);
    }
}
