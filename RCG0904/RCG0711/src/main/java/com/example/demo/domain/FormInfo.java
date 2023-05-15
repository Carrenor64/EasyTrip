package com.example.demo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormInfo{
    @NotEmpty
    private String nombre;
    @Email
    private String email;
    @NotEmpty
    private String lista;
    @Size (max=255)
    private String comentario;
    @NotNull
    private boolean aceptarCondiciones;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLista() {
        return lista;
    }
    public void setLista(String lista) {
        this.lista = lista;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public boolean isAceptarCondiciones() {
        return aceptarCondiciones;
    }
    public void setAceptarCondiciones(boolean aceptarCondiciones) {
        this.aceptarCondiciones = aceptarCondiciones;
    }
    
    
    
}