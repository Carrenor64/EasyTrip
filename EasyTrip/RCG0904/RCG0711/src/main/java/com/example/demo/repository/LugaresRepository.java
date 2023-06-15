package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Pais;

public interface LugaresRepository extends JpaRepository<Lugares, Long> {
    List<Lugares> findByPais(Pais pais);

    Lugares findByNombre(String Nombre);

  
}
