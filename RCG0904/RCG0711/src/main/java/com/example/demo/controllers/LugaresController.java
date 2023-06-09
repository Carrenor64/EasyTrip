package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Lugares;
import com.example.demo.services.FileStorageService;
import com.example.demo.services.LugaresServiceImplMem;
import com.example.demo.services.PaisServicelmplMen;

@Controller
@RequestMapping("/lugares")
public class LugaresController {

    @Autowired
    LugaresServiceImplMem lugaresService;

    @Autowired
    public FileStorageService fileStorageService;

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

    // @PostMapping("/new/submit")
    // public String showNewSubmit(
    // @Valid @ModelAttribute("lugarForm") Lugares nuevoLugar,
    // BindingResult bindingResult) {
    // if (bindingResult.hasErrors())
    // return "newForm";
    // nuevoLugar.setImagen("prueba");
    // lugaresService.add(nuevoLugar);
    // return "redirect:/";
    // }

    // @PostMapping("/new/submit")
    // public String showNewSubmit(
    // @Valid @ModelAttribute("lugarForm") Lugares nuevoLugar, @RequestParam("file")
    // MultipartFile file,
    // BindingResult bindingResult) {
    // if (bindingResult.hasErrors())
    // return "newForm";
    // try {
    // if (!file.isEmpty()) {
    // // String newFileName;
    // String newFileName = fileStorageService.store(file);
    // nuevoLugar.setImagen(newFileName);
    // lugaresService.add(nuevoLugar);
    // return "redirect:/";
    // }
    // } catch (Exception e) {
    // System.out.println(e);
    // return "redirect:/lugares/list";
    // }
    // nuevoLugar.setImagen("prueba");
    // lugaresService.add(nuevoLugar);
    // return "redirect:/";
    // }

    // @PostMapping("/new/submit")
    // public String showNewSubmit(
    // @Valid @ModelAttribute("lugarForm") Lugares lugar,
    // BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
    // // if (bindingResult.hasErrors()) {
    // // return "newForm";
    // // } else {

    // try {
    // if (!file.isEmpty()) {
    // // String newFileName;
    // String newFileName = fileStorageService.store(file);
    // lugar.setImagen(newFileName);
    // lugaresService.add(lugar);
    // return "redirect:/";
    // }
    // } catch (Exception e) {
    // return "lug/lugaresNewView";
    // }
    // // }
    // System.out.println(lugar + "*************");
    // System.out.println(file.getSize());
    // return "redirect:/";
    // }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid @ModelAttribute("lugarForm") Lugares nuevoLugar,
    BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        try {
            String newFileName = "";
            if (!file.isEmpty()) {
                System.out.println("Files:" + file.getSize());
                newFileName = fileStorageService.store(file);

            }
            nuevoLugar.setImagen(newFileName);
            lugaresService.add(nuevoLugar);
            System.out.println("Figure:" + nuevoLugar);
            return "redirect:/lugares/list";
        } catch (Exception e) {
            return "lug/lugaresNewView";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Lugares lugar = lugaresService.findById(id);
        if (lugar != null) {
            model.addAttribute("lugarForm", lugar);
            model.addAttribute("listaPais", paisService.findAll());
            return "lug/lugaresEditView";
        }
        return "redirect:/lugares/list";
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

    // @PostMapping("/edit/submit")
    // public String showEditSubmit(
    // @Valid @ModelAttribute("lugarForm") Lugares lugar,
    // BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
    // try {
    // String newFileName;
    // newFileName = fileStorageService.store(file);
    // lugar.setImagen(newFileName);
    // lugaresService.edit(lugar);
    // return "redirect:/lugares/list";
    // } catch (Exception e) {
    // return "lug/lugaresEditView";
    // }
    // }

    // @PostMapping("/edit/submit")
    // public String showEditSubmit(
    // @Valid @ModelAttribute("lugarForm") Lugares lugar,
    // BindingResult bindingResult,
    // @RequestParam(value = "file", required = false) MultipartFile file) {
    // if (bindingResult.hasErrors()) {
    // return "lug/lugarEditView";
    // } else {
    // if (file != null && !file.isEmpty()) {
    // try {
    // String newFileName = fileStorageService.store(file);
    // lugar.setImagen(newFileName);
    // } catch (Exception e) {
    // // Manejar la excepción en caso de error al almacenar el archivo
    // return "lug/lugarEditView";
    // }
    // }
    // lugaresService.edit(lugar);
    // return "redirect:/lugares/list";
    // }
    // }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        lugaresService.delete(id);
        return "redirect:/lugares/list";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileStorageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }
}
