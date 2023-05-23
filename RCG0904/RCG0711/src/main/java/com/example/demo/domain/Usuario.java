package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Usuario {

    @Id
    @GeneratedValue
    long id;
    String nombre;
    String fechaNacimiento;
    String password;
    Rol rol;
    @ToString.Exclude
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<Valoracion> valoracion = new ArrayList<>();

    public Usuario(String nombre, String fechaNacimiento, String password, Rol rol) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.rol = rol;
    }

}
