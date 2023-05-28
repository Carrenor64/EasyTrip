package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Valoracion;
import com.example.demo.repository.ValoracionRepository;

@Service
public class ValoracionServiceImpl implements ValoracionServicio {
    @Autowired
    ValoracionRepository repositorio;

    public Valoracion add(Valoracion valoracion) {
        return repositorio.save(valoracion);
    }

    public List<Valoracion> findAll() {
        return repositorio.findAll();
    }

    public Valoracion findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Valoracion edit(Valoracion d) {
        return repositorio.save(d);
    }

    public void delete(Valoracion valoracion) {
        repositorio.delete(valoracion);
    }

    public List<Valoracion> findByLugares(Lugares lugares) {
        return repositorio.findByLugares(lugares);
    }

    public List<Valoracion> findByUsuario(Usuario usuario) {
        return repositorio.findByUsuario(usuario);
    }

    public Valoracion findByLugaresAndUsuario(Lugares lu, Usuario usu) {
        return repositorio.findByLugaresAndUsuario(lu, usu);
    }

    // public Valoracion findOneValoracion(long id) {
    //     Valoracion valoracion = repositorio.findById(id)
    //             .orElseThrow(() -> new ValoracionNotFound(id));
    //     return valoracion;
    // }
}
