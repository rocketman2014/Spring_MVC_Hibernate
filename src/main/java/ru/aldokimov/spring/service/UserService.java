package ru.aldokimov.spring.service;


import ru.aldokimov.spring.model.User;

import java.util.List;

public interface UserService {
    public List<User> index();
    public User show(int id);
}
