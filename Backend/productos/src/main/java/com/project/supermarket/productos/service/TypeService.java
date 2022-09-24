package com.project.supermarket.productos.service;

import java.util.List;

import com.project.supermarket.productos.Entity.Type;
import com.project.supermarket.productos.Repository.ITypeRepository;

public class TypeService implements ITypeService {

    private ITypeRepository typeRepository;

    public TypeService(ITypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAllSortByName();
    }

    @Override
    public List<Type> getTypeByName(String name) {
        return typeRepository.findByTitleContaining(name);
    }

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepository.getReferenceById(id);
    }

    @Override
    public Type updateType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void deleteTypeById(Long id) {
        typeRepository.deleteById(id);

    }

}
