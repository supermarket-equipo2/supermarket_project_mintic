package com.project.supermarket.productos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.supermarket.productos.service.UsuarioService;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
