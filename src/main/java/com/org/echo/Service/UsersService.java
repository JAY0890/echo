package com.org.echo.Service;

import com.org.echo.DTO.PostsResponseDTO;
import com.org.echo.DTO.UsersDTO;
import com.org.echo.DTO.UsersResponseDTO;
import com.org.echo.Entities.Posts;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public UsersResponseDTO getuser(int id){
        Users u=usersRepository.findById(id).orElseThrow(()->new RuntimeException("no user found"));
        UsersResponseDTO usersResDTO=new UsersResponseDTO();

        usersResDTO.setEmail(u.getEmail());
        usersResDTO.setFirstname(u.getFirstname());
        usersResDTO.setLastname(u.getLastname());
        usersResDTO.setAge(u.getAge());
        List<PostsResponseDTO> postsResponseDTOS=new ArrayList<>();
        List<Posts> posts=u.getPosts();

        for(Posts p:posts){
            Integer i=p.getId();

            String title=p.getTitle();

            String content=p.getContent();
            LocalDateTime posted_at=p.getPosted_at();

            PostsResponseDTO responseDTO=new PostsResponseDTO(i,title,content,posted_at);
            postsResponseDTOS.add(responseDTO);
        }
        usersResDTO.setPosts(postsResponseDTOS);

        return usersResDTO;
    }

}
