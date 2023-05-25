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
import com.example.demo.services.CategoriaServicelmplMen;
import com.example.demo.services.LugaresServiceImplMem;

@Controller
@RequestMapping("/lugares")
public class LugaresController {

    @Autowired
    LugaresServiceImplMem lugaresService;

    @Autowired
    CategoriaServicelmplMen categoriaService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("listaLugares", lugaresService.findAll());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        model.addAttribute("categoriaSeleccionada", "Todas");
        return "lug/lugaresList";
    }

    @GetMapping("/list/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        // model.addAttribute("listaProductos", productoService.findByCategoria(idCat));
        model.addAttribute("listaLugares", lugaresService.findByCategoria(categoriaService.findById(idCat)));
        model.addAttribute("listaCategorias", categoriaService.findAll());
        model.addAttribute("categoriaSeleccionada", categoriaService.findById(idCat).getNombre());
        return "lug/lugaresList";
    }


    @GetMapping("/{lugar}")
    public String showLugar(@PathVariable String lugar, Model model) {
        Map<String, String> lugarCategoriaMap = new HashMap<>();
        lugarCategoriaMap.put("newyork", "USA");
        lugarCategoriaMap.put("paris", "France");

        String categoria = lugarCategoriaMap.get(lugar);
        if (categoria != null) {
            model.addAttribute("lugar", categoriaService.findByNombre(categoria));
            return lugar;
        }

        // Si el lugar no existe en el mapa, puedes manejarlo de alguna otra manera,
        // como mostrar una página de error.
        return "error";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        // el commandobject del formulario es una instancia de producto vacia
        model.addAttribute("lugarForm", new Lugares());
        model.addAttribute("listaCategorias", categoriaService.findAll());
        return "lug/lugaresNewView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("lugarForm") Lugares nuevoLugar,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newForm";
        lugaresService.add(nuevoLugar);
        return "redirect:/lugares/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Lugares lugar = lugaresService.findById(id);
        // el commandobject del formulario es el producto con el id solicitado
        if (lugar != null) {
            model.addAttribute("lugarForm", lugar);
            model.addAttribute("listaCategorias", categoriaService.findAll());
            return "lug/lugaresEditView";
        }
        // si no lo encuentra vuelve a la página de inicio.
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
