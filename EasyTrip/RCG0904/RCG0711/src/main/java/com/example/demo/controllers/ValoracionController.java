package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Lugares;
import com.example.demo.domain.Usuario;
import com.example.demo.domain.Valoracion;
import com.example.demo.services.LugaresService;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.ValoracionServicio;

@Controller
@RequestMapping("/valoracion")
public class ValoracionController {
    @Autowired
    public ValoracionServicio valoracionServicio;
    @Autowired
    public LugaresService lugaresService;
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/lug/{id}") 
    public String showProyectsByEmpl(@PathVariable long id, Model model) {
        Lugares p = lugaresService.findById(id);
        model.addAttribute("listaValoracion", valoracionServicio.findByLugares(p));
        model.addAttribute("lugares", lugaresService.findById(id));
        return "val/lugListView";
    }

    @GetMapping("/usu/{id}") 
    public String showEmplbyProyect(@PathVariable long id, Model model) {
        Usuario u = usuarioService.findById(id);
        model.addAttribute("listaValoracion", valoracionServicio.findByUsuario(u));
        model.addAttribute("usuario", usuarioService.findById(id));
        return "val/usuListView";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        valoracionServicio.delete(valoracionServicio.findById(id));
        return "redirect:/";
    }

    @GetMapping("/nuevo")
    public String showNewProjectEmpl(Model model) {
        model.addAttribute("valoracionForm", new Valoracion());
        model.addAttribute("listaLugares", lugaresService.findAll());
        model.addAttribute("listaUsuario", usuarioService.findAll());
        return "val/lugUsuNewFormView";
    }

    @PostMapping("/nuevo/submit")
    public String showNewProjectEmplSubmit(
            @Valid @ModelAttribute("valoracionForm") Valoracion nuevaValoracion,
            BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            nuevaValoracion = valoracionServicio.add(nuevaValoracion);
        return "redirect:/";
    }

}

