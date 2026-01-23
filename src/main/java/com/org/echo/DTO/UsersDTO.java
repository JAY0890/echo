package com.org.echo.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {

    @Email(message = "please enter a valid email")
    @NotNull(message = "email can't be null")
    String email;

    @NotBlank(message = "password can't be blank")
    @Size(min = 6,max = 20,message = "password length should be between 6 to 20")
    String password;

    @NotBlank(message = "firstname can't be blank")
    @Size(max = 100)
    String firstname;

    @NotBlank(message = "lastname can't be blank")
    @Size(max = 100)
    String lastname;

    @Max(value = 150,message = "enter a valid age")
    @Min(value = 10,message = "minimum age should be 10")
    Integer age;

}
