package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.FormInfo;

@Controller
public class MainController {
        LocalDate fechaActual = LocalDate.now();
        String anhoActual = Integer.toString(fechaActual.getYear());
        HashSet<String> producto = new HashSet<>();

        @GetMapping({ "/index", "/home", "/", "" })
        public String showHome(@RequestParam(name = "usuario") Optional<String> usuario,
                        Model model) {
                model.addAttribute("fechaActual", anhoActual);
                model.addAttribute("usuario", usuario.orElse("X"));
                return "index";
        }

        @GetMapping("/contacta")
        public String showContacto(Model model) {
                model.addAttribute("formInfo", new FormInfo());
                return "contacta";
        }


        @GetMapping("/corunha")
        public String showCorunha() {
                return "corunha";
        }

        @GetMapping("/tokio")
        public String showTokio() {
                return "tokio";
        }

        @GetMapping("/paris")
        public String showParis() {
                return "paris";
        }

        @GetMapping("/brasilia")
        public String showBrasilia() {
                return "brasilia";
        }

        @PostMapping("/contacta/submit")
        public String showMyformView(@Valid FormInfo formInfo, BindingResult bindingResult) {
                System.out.println(formInfo.getNombre());
                if (bindingResult.hasErrors()) {
                        return "redirect:/contacta";
                } else {
                        return "formSubmit";
                }
        }
}
