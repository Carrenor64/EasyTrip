package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
    Pais findByNombre(String nombre);
}
