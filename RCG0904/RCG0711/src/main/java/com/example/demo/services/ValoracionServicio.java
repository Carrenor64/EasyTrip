package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Valoracion;

public interface ValoracionServicio {
    public Valoracion findById(Long id);

    public Valoracion add(Valoracion valoracion);

    public void delete(Valoracion valoracion);

    public List<Valoracion> findByProductos(Lugares productos);

    public List<Valoracion> findByUsuario(Usuario usuario);

    public Valoracion findByProductosAndUsuario(Lugares pro, Usuario usu);
}
