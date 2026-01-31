package com.org.echo.DTO;

import com.org.echo.Entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostsResponseDTO {

    Integer id;

    String title;

    String content;

    LocalDateTime posted_at;

    Set<Category> categories;
}
