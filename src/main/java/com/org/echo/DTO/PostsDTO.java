package com.org.echo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsDTO {

    @NotBlank
    @Size(min = 10,max = 20,message = "minimum title length is 10 and max is 20")
    String title;

    @Size(min = 5,max = 250,message = "minimum content length is 50 and max is 250")
    String content;

    @NotNull(message = "please provide a valid id")
    Integer userid;

    int[] categories;
}
