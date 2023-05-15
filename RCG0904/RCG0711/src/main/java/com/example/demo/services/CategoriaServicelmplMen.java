package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaServicelmplMen implements CategoriaService {
    @Autowired
    CategoriaRepository repositorio;

    public Categoria add(Categoria e) {
        return repositorio.save(e);
    }

    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    public Categoria findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Categoria edit(Categoria d) {
        return repositorio.save(d);
    }

    public void delete(Categoria d) {
        repositorio.delete(d); // también es cómodo deleteById(id)
    }

    public Categoria findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }
}
