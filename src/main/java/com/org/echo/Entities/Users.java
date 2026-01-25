package com.org.echo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

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

     @OneToMany(mappedBy = "users")
     @JsonIgnoreProperties("users")
     List<Posts> posts;

}
