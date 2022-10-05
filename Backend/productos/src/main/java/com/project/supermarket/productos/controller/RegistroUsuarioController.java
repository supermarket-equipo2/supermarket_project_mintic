package com.project.supermarket.productos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.supermarket.productos.service.IUsuarioService;
import com.project.supermarket.productos.dto.UsuarioRegistroDTO;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {
    private IUsuarioService usuarioService;

    public RegistroUsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioService.save(registroDTO);
        return "redirect:/registro?exito";
    }
}
