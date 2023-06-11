package com.example.demo.domain;

import org.springframework.web.multipart.MultipartFile;

public class ImagenForm {
    private MultipartFile imagen;

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }
}
