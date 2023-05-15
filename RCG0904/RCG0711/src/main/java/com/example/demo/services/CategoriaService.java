package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Categoria;

public interface CategoriaService {
    Categoria add(Categoria categoria); 
    List<Categoria> findAll(); 
    Categoria findById(long id); 
    Categoria edit(Categoria e); 
    void delete(Categoria d); 
    Categoria findByNombre(String nombre);
}
