package com.example.demo.exceptions;

public class LugaresEmptyException extends RuntimeException {
    public LugaresEmptyException() {
        super("No hay productos en el sistema");
    }
}
