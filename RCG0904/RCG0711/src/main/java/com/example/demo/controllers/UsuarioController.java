package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Usuario;
import com.example.demo.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
    model.addAttribute("listaUsuario", usuarioService.findAll());
    return "usu/usuariolistView";
    }

    // public String showList(Model model) {
    //     model.addAttribute("listaUsuario", usuarioService.findAll());

    //     // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     // boolean esAdministrador = authentication.getAuthorities().stream()
    //     //         .map(GrantedAuthority::getAuthority)
    //     //         .anyMatch(role -> role.equals("ADMIN"));

    //     // model.addAttribute("esAdministrador", esAdministrador);
    //     // // Asegúrate de que este string coincide con el nombre del
    //     // // rol de administrador

    //     return "usu/usuariolistView";
    // }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "usu/usuarioNewFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "usu/usuarioNewFormView";
        }
        nuevoUsuario = usuarioService.add(nuevoUsuario);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        usuarioService.delete(usuarioService.findById(id));
        return "redirect:/usuario/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            model.addAttribute("usuarioForm", usuario);
            return "usu/usuarioEditFormView";
        } else {
            return "redirect:/usuario/list";
        }
    }

    @PostMapping("/edit/submit")
    public String showEditSubmit(
            @Valid @ModelAttribute("usuarioForm") Usuario usuario,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "usu/usuarioEditFormView";
        }
        usuarioService.edit(usuario);
        return "redirect:/usuario/list";
    }

}
