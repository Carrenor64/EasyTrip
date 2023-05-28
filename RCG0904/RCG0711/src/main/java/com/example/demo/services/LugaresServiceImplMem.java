package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Pais;
import com.example.demo.repository.LugaresRepository;

@Service
public class LugaresServiceImplMem implements LugaresService {

    @Autowired
    LugaresRepository repositorio;

    public List<Lugares> findByPais(Pais pais) {
        return repositorio.findByPais(pais);
    }

    public Lugares add(Lugares p) {
        repositorio.save(p);
        return p;
    }

    public List<Lugares> findAll() {
        return repositorio.findAll();
    }

    public Lugares findById(long id) {
        return repositorio.findById(id).orElse(null);

    }

    public Lugares edit(Lugares e) {
        return repositorio.save(e);
    }

    public void delete(Long id) {
        repositorio.deleteById(id);
    }

    public Lugares findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

}