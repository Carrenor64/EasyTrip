package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Pais;

public interface PaisService {
    Pais add(Pais pais); 
    List<Pais> findAll(); 
    Pais findById(long id); 
    Pais edit(Pais e); 
    void delete(Pais d); 
    Pais findByNombre(String nombre);
}
