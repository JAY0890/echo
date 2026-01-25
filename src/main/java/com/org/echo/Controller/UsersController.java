package com.org.echo.Controller;

import com.org.echo.DTO.PostsResponseDTO;
import com.org.echo.DTO.UsersDTO;
import com.org.echo.DTO.UsersResponseDTO;
import com.org.echo.Entities.Posts;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.UsersRepository;
import com.org.echo.Service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users user(@RequestBody @Valid UsersDTO usersDTO){

        return usersService.register(usersDTO);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsersResponseDTO finduser(@PathVariable int id){
         return usersService.getuser(id);
    }

}
