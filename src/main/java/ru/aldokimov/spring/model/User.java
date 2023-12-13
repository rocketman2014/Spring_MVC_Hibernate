package ru.aldokimov.spring.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@Component
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotEmpty(message = "The name must not be empty.")
    @Size(min = 2, max = 30, message = "The name must be between 2 and 30 characters.")
    private String name;
    @Column(name = "surename")
    @NotEmpty(message = "The username must not be empty.")
    @Size(min = 2, max = 30, message = "The username must be between 2 and 30 characters.")
    private String sureName;
    @Column(name = "age")
    @Min(value = 0, message = "Age must be greater than 0.")
    private byte age;
    @Column(name = "email")
    @Email(message = "Email must comply with the standard.")
    @NotEmpty(message = "Email must not be empty.")
    private String email;

    public User(Long id, String name, String sureName, byte age) {
        this.id = id;
        this.name = name;
        this.sureName = sureName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public User() {

    }
}
