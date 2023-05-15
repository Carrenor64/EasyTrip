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
    private Categoria categoria;

    
    @ToString.Exclude
    @OneToMany(mappedBy = "productos", cascade = CascadeType.REMOVE)
    private List<Valoracion> valoracion = new ArrayList<>();

    String nombre;
    boolean enOferta;
    TipoIva tipoIva;
    double precio;
    long idCategoria;

    public Lugares(String nombre, boolean enOferta, TipoIva tipoIva, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.enOferta = enOferta;
        this.tipoIva = tipoIva;
        this.precio = precio;
        this.categoria = categoria;

    }
}
