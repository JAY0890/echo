package com.org.echo.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true,nullable = false)
    String email;

    @Column(nullable = false)
    String password;

    String firstname;

    String lastname;

    Integer age;

    @CreationTimestamp
    @Column(updatable = false,name = "registered_at")
    LocalDate registered_at;



}
