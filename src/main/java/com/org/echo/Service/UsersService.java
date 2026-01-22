package com.org.echo.Service;

import com.org.echo.DTO.UsersDTO;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;


    public Users register(UsersDTO usersDTO){
        Users user=new Users();

        user.setEmail(usersDTO.getEmail());
        user.setPassword(usersDTO.getPassword());
        user.setFirstname(usersDTO.getFirstname());
        user.setLastname(usersDTO.getLastname());
        user.setAge(usersDTO.getAge());

        usersRepository.save(user);
        return user;
    }

}
