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

import com.example.demo.domain.Pais;
import com.example.demo.services.LugaresServiceImplMem;
import com.example.demo.services.PaisServicelmplMen;

@Controller
@RequestMapping("/pais")
public class PaisController {
    

    @Autowired
    PaisServicelmplMen paisService;
    @Autowired
    LugaresServiceImplMem productoService;

    @GetMapping({ "/", "/list",""})
    public String showList(Model model) {
        model.addAttribute("listaPais", paisService.findAll());
        return "pa/paisList";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de producto vacia
        model.addAttribute("paisForm", new Pais());
        return "pa/paisNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("paisForm") Pais nuevoPais,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
            paisService.add(nuevoPais);
        return "redirect:/pais/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Pais pais = paisService.findById(id);
        // el commandobject del formulario es el producto con el id solicitado
        if (pais != null) {
            model.addAttribute("paisForm", pais);
            return "pa/paisEditView";
        }
        // si no lo encuentra vuelve a la página de inicio.
        return "redirect:/pais";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("paisForm") Pais pais,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pa/paisEditView";
        } else {
            paisService.edit(pais);
            return "redirect:/pais/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        paisService.delete(paisService.findById(id));
        return "redirect:/pais/list";
    }
}
