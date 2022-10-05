package com.project.supermarket.productos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.supermarket.productos.Entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}
