package com.org.echo.Service;

import com.org.echo.DTO.PostsDTO;
import com.org.echo.DTO.PostsResponseDTO;
import com.org.echo.Entities.Posts;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.PostsRepository;
import com.org.echo.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PostsRepository postsRepository;

    public Posts createPost(PostsDTO postsDTO){

        Users u=usersRepository.findById(postsDTO.getUserid()).orElseThrow(()->new RuntimeException("No user found with "+postsDTO.getUserid()+" id"));

        Posts p=new Posts();
        p.setTitle(postsDTO.getTitle());
        p.setContent(p.getContent());
        p.setUsers(u);

        return p;
    }

    public PostsResponseDTO getpost(int id){

        Posts p=postsRepository.findById(id).orElseThrow(()->new RuntimeException("No post found with this id "+id));

        PostsResponseDTO postsResponseDTO=new PostsResponseDTO();

        postsResponseDTO.setId(p.getId());
        postsResponseDTO.setTitle(p.getTitle());
        postsResponseDTO.setContent(p.getContent());
        postsResponseDTO.setPosted_at(p.getPosted_at());

        return postsResponseDTO;
    }
}
