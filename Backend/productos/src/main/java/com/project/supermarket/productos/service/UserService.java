package com.project.supermarket.productos.service;

import com.project.supermarket.productos.Entity.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public List<Object> isUserPresent(User user);
}
