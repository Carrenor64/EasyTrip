package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pais;
import com.example.demo.repository.PaisRepository;

@Service
public class PaisServicelmplMen implements PaisService {
    @Autowired
    PaisRepository repositorio;

    public Pais add(Pais e) {
        return repositorio.save(e);
    }

    public List<Pais> findAll() {
        return repositorio.findAll();
    }

    public Pais findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Pais edit(Pais d) {
        return repositorio.save(d);
    }

    public void delete(Pais d) {
        repositorio.delete(d); // también es cómodo deleteById(id)
    }

    public Pais findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public void save(Pais pais) {
    }
}
