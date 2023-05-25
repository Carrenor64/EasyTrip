package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Lugares;

public interface LugaresRepository extends JpaRepository<Lugares, Long> {
    List<Lugares> findByCategoria(Categoria categoria);

    Lugares findByNombre(String Nombre);

  
}
