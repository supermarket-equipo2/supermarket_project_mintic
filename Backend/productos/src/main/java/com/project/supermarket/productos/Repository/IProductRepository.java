package com.project.supermarket.productos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.supermarket.productos.Entity.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product s WHERE s.productName LIKE :name")
    public List<Product> findByNameContaining(@Param("name") String name);

}
