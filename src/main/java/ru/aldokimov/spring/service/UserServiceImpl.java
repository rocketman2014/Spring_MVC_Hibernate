package ru.aldokimov.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.aldokimov.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id= :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findFirst().orElse(null);
    }

}
