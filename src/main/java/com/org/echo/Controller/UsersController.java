package com.org.echo.Controller;

import com.org.echo.DTO.UsersDTO;
import com.org.echo.Entities.Users;
import com.org.echo.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;


    @PostMapping("/register")
    public Users user(@RequestBody UsersDTO usersDTO){

        return usersService.register(usersDTO);
    }
}
