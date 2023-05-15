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

    public Valoracion findById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void delete(Valoracion valoracion) {
        repositorio.delete(valoracion);
    }

    public List<Valoracion> findByProductos(Lugares productos) {
        return repositorio.findByProductos(productos);
    }

    public List<Valoracion> findByUsuario(Usuario usuario) {
        return repositorio.findByUsuario(usuario);
    }

    public Valoracion findByProductosAndUsuario(Lugares pro, Usuario usu) {
        return repositorio.findByProductosAndUsuario(pro, usu);
    }
}
