package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Usuario;

public interface UsuarioService {
    Usuario add(Usuario Usuario);
    List<Usuario> findAll();
    Usuario findById(long id);
    Usuario edit(Usuario Usuario);
    void delete(Usuario Usuario);
    Usuario findByNombre(String nombre);
}
