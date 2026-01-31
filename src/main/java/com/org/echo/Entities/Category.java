package com.org.echo.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "category_name",unique = true, nullable = false)
    String categoryName;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    Set<Posts> posts=new HashSet<>();
}
