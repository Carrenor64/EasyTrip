package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    int puntuacion;
    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Lugares productos;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String comentario;

    public Valoracion(int puntuacion, Lugares productos,Usuario usuario, String comentario) {
        this.puntuacion = puntuacion;
        this.productos = productos;
        this.usuario = usuario;
        this.comentario = comentario;
    }

}
