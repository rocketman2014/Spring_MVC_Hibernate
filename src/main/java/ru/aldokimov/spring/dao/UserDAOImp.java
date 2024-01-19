package ru.aldokimov.spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aldokimov.spring.model.User;

import java.util.List;
@Repository
public class UserDAOImp implements UserDAO{
    private final EntityManager entityManager;
    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        entityManager.persist(user);
    }
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
