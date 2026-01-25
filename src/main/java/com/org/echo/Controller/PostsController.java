package com.org.echo.Controller;

import com.org.echo.DTO.PostsDTO;
import com.org.echo.DTO.PostsResponseDTO;
import com.org.echo.Entities.Posts;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.PostsRepository;
import com.org.echo.Repository.UsersRepository;
import com.org.echo.Service.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    UsersRepository  usersRepository;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    PostsService postsService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Posts createpost(@RequestBody @Valid PostsDTO postsDTO){

        return postsService.createPost(postsDTO);

    }

    @GetMapping("/getpost/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostsResponseDTO getpost(@PathVariable int id){

       return postsService.getpost(id);
    }
}
