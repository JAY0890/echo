package com.org.echo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    String content;

    @CreationTimestamp
    @Column(columnDefinition = "TIMESTAMP(0)")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime posted_at;

    @ManyToOne
    Users users;

    @ManyToMany
    @JoinTable(
            name = "post_category",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    Set<Category> categories=new HashSet<>();
}
