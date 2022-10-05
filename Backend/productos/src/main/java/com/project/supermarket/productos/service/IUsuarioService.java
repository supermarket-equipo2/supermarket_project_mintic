package com.project.supermarket.productos.service;

import com.project.supermarket.productos.dto.UsuarioRegistroDTO;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.supermarket.productos.Entity.Usuario;

public interface IUsuarioService extends UserDetailsService {
    public Usuario save(UsuarioRegistroDTO registroDTO);

}
