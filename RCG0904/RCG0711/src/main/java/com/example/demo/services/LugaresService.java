package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Lugares;

public interface LugaresService {
    public Lugares add(Lugares p);
    public List<Lugares> findAll();
    public Lugares findById(long id);
    public Lugares edit(Lugares p);
    public void delete(Long id);
    public List<Lugares> findByCategoria(Categoria categoria);
    public Lugares findByNombre(String nombre);
}
