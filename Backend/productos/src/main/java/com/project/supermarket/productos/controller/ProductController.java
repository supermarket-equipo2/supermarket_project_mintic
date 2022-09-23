package com.project.supermarket.productos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Esta etiqueta se utiliza para darle instrucciones a Springboot
public class ProductController {

    @RequestMapping("/") // Esto retorna una cadena de string de una página web y la va a asociar con un
                         // enlace
    public String principal() {
        return "create_product";
    }

    @RequestMapping("/products") // Esto retorna una cadena de string de una página web y la va a asociar con un
    // enlace
    public String productos() {
        return "products";
    }

    @RequestMapping("/editar") // Esto retorna una cadena de string de una página web y la va a asociar con un
    // enlace
    public String editar() {
        return "edit_product";
    }
}
