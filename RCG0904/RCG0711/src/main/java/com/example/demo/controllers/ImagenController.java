package com.example.demo.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.core.io.ClassPathResource;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImagenController {
    @GetMapping("/imagenes/{imgName}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String imgName) {
        Resource res = new ClassPathResource("static/img/monumentos/" + imgName);
        HttpHeaders http = new HttpHeaders();
        http.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.ok().headers(http).body(res);
    }

    // @PostMapping("/upload")
    // public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file);
}
