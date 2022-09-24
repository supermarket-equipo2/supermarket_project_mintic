package com.project.supermarket.productos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.supermarket.productos.Entity.Type;

public interface ITypeRepository extends JpaRepository<Type, Long> {

    @Query("FROM Type c WHERE c.name like :title")
    List<Type> findByTitleContaining(@Param("title") String title);

    @Query("FROM Type c ORDER BY name ASC")
    public List<Type> findAllSortByName();

}