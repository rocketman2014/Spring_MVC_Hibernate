package ru.aldokimov.spring.dao;

import ru.aldokimov.spring.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    void save(User user);
    User findById(Long id);
    void delete(Long id);
}
