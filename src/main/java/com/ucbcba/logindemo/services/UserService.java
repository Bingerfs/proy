package com.ucbcba.logindemo.services;

import com.ucbcba.logindemo.entities.User;

public interface UserService {
    void save(User user);
    Iterable<User> listAllUsers();
    User findByUsername(String username);
}