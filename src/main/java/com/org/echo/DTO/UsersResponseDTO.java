package com.org.echo.DTO;

import com.org.echo.Entities.Posts;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UsersResponseDTO {

    String email;

    String firstname;

    String lastname;

    Integer age;

    List<PostsResponseDTO> posts;
}
