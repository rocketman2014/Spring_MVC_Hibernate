package ru.aldokimov.spring.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotBlank
    @NotEmpty(message = "The name must not be empty.")
    @Size(min = 2, max = 30, message = "The name must be between 2 and 30 characters.")
    private String name;
    @Column(name = "surname")
    @NotBlank
    @NotEmpty(message = "The username must not be empty.")
    @Size(min = 2, max = 30, message = "The username must be between 2 and 30 characters.")
    private String surname;
    @Column(name = "age")
    @Min(value = 0, message = "Age must be greater than 0.")
    private byte age;
    @Column(name = "email")
    @NotBlank
    @Email(message = "Email must comply with the standard.")
    @NotEmpty(message = "Email must not be empty.")
    private String email;

    public User(Long id, String name, String surname, byte age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surename) {
        this.surname = surename;
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

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", sureName='" + surname + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               '}';
    }
}
