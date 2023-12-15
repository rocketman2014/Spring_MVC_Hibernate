package ru.aldokimov.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aldokimov.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
