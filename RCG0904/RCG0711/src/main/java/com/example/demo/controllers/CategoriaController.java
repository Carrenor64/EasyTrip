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

import com.example.demo.domain.Categoria;
import com.example.demo.services.CategoriaServicelmplMen;
import com.example.demo.services.LugaresServiceImplMem;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    

    @Autowired
    CategoriaServicelmplMen categoriaService;
    @Autowired
    LugaresServiceImplMem productoService;

    @GetMapping({ "/", "/list",""})
    public String showList(Model model) {
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "cat/categoriaList";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de producto vacia
        model.addAttribute("categoriaForm", new Categoria());
        return "cat/categoriaNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("categoriaForm") Categoria nuevoCategoria,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
            categoriaService.add(nuevoCategoria);
        return "redirect:/categoria/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        // el commandobject del formulario es el producto con el id solicitado
        if (categoria != null) {
            model.addAttribute("categoriaForm", categoria);
            return "cat/categoriaEditView";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/categoria";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("categoriaForm") Categoria categoria,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cat/categoriaEditView";
        } else {
            categoriaService.edit(categoria);
            return "redirect:/categoria/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        categoriaService.delete(categoriaService.findById(id));
        return "redirect:/categoria/list";
    }
}
