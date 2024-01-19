package ru.aldokimov.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aldokimov.spring.dao.UserDAOImp;
import ru.aldokimov.spring.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl {
    private final UserDAOImp userRepository;

    @Autowired
    public UserServiceImpl(UserDAOImp userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.getAll();
    }

    public User findOne(Long id) {
        Optional<User> foundUser = Optional.ofNullable(userRepository.findById(id));
        return foundUser.orElse(new User());
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, User updatetUser) {
        updatetUser.setId(id);
        userRepository.save(updatetUser);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
