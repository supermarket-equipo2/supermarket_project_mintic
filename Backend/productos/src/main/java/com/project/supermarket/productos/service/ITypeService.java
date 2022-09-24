package com.project.supermarket.productos.service;

import java.util.List;

import com.project.supermarket.productos.Entity.Type;

public interface ITypeService {

    List<Type> getAllTypes();

    List<Type> getTypeByName(String name);

    Type saveType(Type type);

    Type getTypeById(Long id);

    Type updateType(Type type);

    void deleteTypeById(Long id);

}
