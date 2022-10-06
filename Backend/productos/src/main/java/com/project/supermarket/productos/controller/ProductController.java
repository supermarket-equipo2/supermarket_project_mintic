package com.project.supermarket.productos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.thymeleaf.engine.AttributeName;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.supermarket.productos.Repository.ITypeRepository;
import com.project.supermarket.productos.service.ProductService;
import com.project.supermarket.productos.Entity.Product;
import com.project.supermarket.productos.Entity.Type;

@Controller // Esta etiqueta se utiliza para darle instrucciones a Springboot
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ITypeRepository typeRepository;

    private List<Type> typesList = new ArrayList<>();

    public ProductController(ProductService productService, ITypeRepository typeRepository) {
        this.productService = productService;
        this.typeRepository = typeRepository;
        this.typesList = this.typeRepository.findAllSortByName();
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/carrito")
    public String carrito_index() {
        return "carrito";
    }

    @RequestMapping("/cart.html")
    public String cart() {
        return "cart";
    }

    @RequestMapping("/checkout.html")
    public String checkout() {
        return "checkout";
    }
    // Al descomentar esto, el home va a ser la página de la tabla de productos
    // @GetMapping("/")
    // public String home(Model model) {
    // model.addAttribute("products", productService.getAllProducts());
    // return "products";
    // }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    /**
     * @param model
     * @param flash
     * @return
     */
    @GetMapping("/products/new")
    public String createProductForm(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);
        model.addAttribute("typesList", typesList);

        return "create_product";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product, RedirectAttributes flash) {
        productService.saveProduct(product);
        // Mensaje de éxito
        flash.addFlashAttribute("mensaje", "Agregado correctamente")
                .addFlashAttribute("clase", "success");
        // Fin mensaje de éxito

        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product st = productService.getProductById(id);

        model.addAttribute("product", st);
        model.addAttribute("typesList", typesList);

        return "edit_product";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,
            @ModelAttribute("product") Product product,
            Model model, RedirectAttributes flash) {
        // sacar el estudiante de la b.d. por el id
        Product existentProduct = productService.getProductById(id);
        // cargarlo
        existentProduct.setId(id);
        existentProduct.setProductName(product.getProductName());
        existentProduct.setProductPrice(product.getProductPrice());
        existentProduct.setCantidadProducto(product.getCantidadProducto());
        existentProduct.setProveedorProducto(product.getProveedorProducto());

        // guardar el estudiante actualizado
        productService.updateProduct(existentProduct);

        // Mensaje de éxito
        flash.addFlashAttribute("mensaje", "Actualizado correctamente")
                .addFlashAttribute("clase", "success");
        // Fin mensaje de éxito

        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes flash) {
        productService.deleteProductById(id);

        // Mensaje de éxito
        flash.addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "success");
        // Fin mensaje de éxito

        return "redirect:/products";
    }

    // @RequestMapping("/") // Esto retorna una cadena de string de una página web y
    // la va a asociar con un
    // // enlace
    // public String principal() {
    // return "create_product";
    // }

    // @RequestMapping("/products") // Esto retorna una cadena de string de una
    // página web y la va a asociar con un
    // // enlace
    // public String productos() {
    // return "products";
    // }

    // @RequestMapping("/editar") // Esto retorna una cadena de string de una página
    // web y la va a asociar con un
    // // enlace
    // public String editar() {
    // return "edit_product";
    // }
}
