package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Lugares {
    @Id
    @GeneratedValue
    long id;

    @ToString.Exclude
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pais pais;

    @ToString.Exclude
    @OneToMany(mappedBy = "lugares", cascade = CascadeType.REMOVE)
    private List<Valoracion> valoracion = new ArrayList<>();

    String ubicacion;
    String nombre;
    String descripcion;
    double precio;
    // long idPais;
    String imagen;

    public Lugares(String ubicacion, String nombre, String descripcion, double precio,
            Pais pais, String imagen) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.pais = pais;
        this.imagen = imagen;

    }
}
