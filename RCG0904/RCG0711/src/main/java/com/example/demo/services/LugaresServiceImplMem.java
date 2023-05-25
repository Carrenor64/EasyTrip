package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Lugares;
import com.example.demo.repository.LugaresRepository;

@Service
public class LugaresServiceImplMem implements LugaresService {

    @Autowired
    LugaresRepository repositorio;

    public List<Lugares> findByCategoria(Categoria categoria) {
        return repositorio.findByCategoria(categoria);
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


    // public List<Productos> findAll() {
    // return repositorio;
    // }

    // public Productos findById(long id) {
    // for (Productos p : repositorio)
    // if (p.getId() == id)
    // return p;
    // return null;
    // }

    // public Productos edit(Productos p) {
    // int pos = repositorio.indexOf(p);
    // if (pos == -1)
    // repositorio.add(p);
    // else
    // repositorio.set(pos, p);
    // return p;
    // }

    // public int delete(Long id) {
    // Productos p = this.findById(id);
    // if (p != null) {
    // repositorio.remove(p);
    // return 1;
    // }
    // return 0;
    // }

    // public List<Productos> findByCategoria(long idCat) {
    // ArrayList<Productos> listaPro = new ArrayList<>();
    // for (Productos p : repositorio)
    // if (p.getIdCategoria() == idCat)
    // listaPro.add(p);
    // return listaPro;
    // }
}