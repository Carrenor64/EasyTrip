package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/logout")
    public String showLogout() {
        return "logout";
    }

    @PostMapping("/accessError")
    public String showError() {
        return "accessError";
    }
}
