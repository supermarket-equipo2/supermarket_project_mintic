package com.project.supermarket.productos.service;

import java.util.List;

import com.project.supermarket.productos.Entity.Product;

public interface IProductService {

    List<Product> getAllProducts();

    List<Product> getProductByName(String name);

    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

}
