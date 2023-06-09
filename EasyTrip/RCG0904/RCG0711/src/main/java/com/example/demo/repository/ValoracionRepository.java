package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByLugares(Lugares lugares);

    List<Valoracion> findByUsuario(Usuario usuario);

    Valoracion findByLugaresAndUsuario(Lugares lu, Usuario usu);
}
