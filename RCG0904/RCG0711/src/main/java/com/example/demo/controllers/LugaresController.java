package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

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
import com.example.demo.services.LugaresServiceImplMem;
import com.example.demo.services.PaisServicelmplMen;

@Controller
@RequestMapping("/lugares")
public class LugaresController {

    @Autowired
    LugaresServiceImplMem lugaresService;

    @Autowired
    PaisServicelmplMen paisService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("listaLugares", lugaresService.findAll());
        model.addAttribute("listaPais", paisService.findAll());
        model.addAttribute("paisSeleccionada", "Todas");
        return "lug/lugaresList";
    }

    @GetMapping("/list/{idPais}")
    public String showListInCategory(@PathVariable Long idPais, Model model) {
        model.addAttribute("listaLugares", lugaresService.findByPais(paisService.findById(idPais)));
        model.addAttribute("listaPais", paisService.findAll());
        model.addAttribute("paisSeleccionada", paisService.findById(idPais).getNombre());
        return "lug/lugaresList";
    }

    @GetMapping("/{lugar}")
    public String showLugar(@PathVariable String lugar, Model model) {
        Map<String, String> lugarCategoriaMap = new HashMap<>();
        lugarCategoriaMap.put("newyork", "USA");
        lugarCategoriaMap.put("paris", "France");
        lugarCategoriaMap.put("corunha", "España");
        lugarCategoriaMap.put("brasilia", "Brasil");
        lugarCategoriaMap.put("tokio", "Japon");

        String pais = lugarCategoriaMap.get(lugar);
        if (pais != null) {
            model.addAttribute("lugar", paisService.findByNombre(pais));
            return lugar;
        }

        return "error";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        Map<String, String> lugarCategoriaMap = new HashMap<>();
        lugarCategoriaMap.put("newyork", "USA");
        lugarCategoriaMap.put("paris", "France");
        lugarCategoriaMap.put("corunha", "España");
        lugarCategoriaMap.put("brasilia", "Brasil");
        lugarCategoriaMap.put("tokio", "Japon");

        String lugar = "newyork"; // Reemplaza con el lugar que desees
        String pais = lugarCategoriaMap.get(lugar);
        if (pais != null) {
            model.addAttribute("lugar", paisService.findByNombre(pais));
            model.addAttribute("lugarForm", new Lugares());
            model.addAttribute("listaPais", paisService.findAll());
            return "lug/lugaresNewView";
        }

        return "error";
    }

    // @GetMapping("/new")
    // public String showNew(Model model) {
    // model.addAttribute("lugarForm", new Lugares());
    // model.addAttribute("listaPais", paisService.findAll());
    // return "lug/lugaresNewView";
    // }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("lugarForm") Lugares nuevoLugar,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
        lugaresService.add(nuevoLugar);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Lugares lugar = lugaresService.findById(id);
        if (lugar != null) {
            model.addAttribute("lugarForm", lugar);
            model.addAttribute("listaPais", paisService.findAll());
            return "lug/lugaresEditView";
        }
        return "redirect:/lugares";
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("lugarForm") Lugares lugar,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lug/lugarEditView";
        } else {
            lugaresService.edit(lugar);
            return "redirect:/lugares/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        lugaresService.delete(id);
        return "redirect:/lugares/list";
    }
}
