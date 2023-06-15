package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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

    String nombre;
    String horario;
    String descripcion;
    String precioEU;
    @Lob
    private byte[] imagenData;

    public Lugares(String nombre, String horario, String descripcion, String precioEU,
            Pais pais, byte[] imagenData) {
        this.nombre = nombre;
        this.horario = horario;
        this.descripcion = descripcion;
        this.precioEU = precioEU;
        this.pais = pais;
        this.imagenData = imagenData;

    }
}
