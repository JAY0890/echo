package com.org.echo.Service;

import com.org.echo.DTO.PostsResponseDTO;
import com.org.echo.DTO.UsersDTO;
import com.org.echo.DTO.UsersResponseDTO;
import com.org.echo.Entities.Category;
import com.org.echo.Entities.Posts;
import com.org.echo.Entities.Users;
import com.org.echo.Repository.UsersRepository;
import com.org.echo.DTO.AuthResponseDTO;
import com.org.echo.DTO.LoginRequestDTO;
import com.org.echo.securityconfig.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;

    public Users register(UsersDTO usersDTO){
        Users user=new Users();

        user.setEmail(usersDTO.getEmail());
        user.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        user.setFirstname(usersDTO.getFirstname());
        user.setLastname(usersDTO.getLastname());
        user.setAge(usersDTO.getAge());

        usersRepository.save(user);
        return user;
    }

    public UsersResponseDTO getuser(int id){
        Users u=usersRepository.findByIdWithPostsAndCategories(id).orElseThrow(()->new RuntimeException("no user found"));
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
            Set<Category> categories=p.getCategories();
            PostsResponseDTO responseDTO=new PostsResponseDTO(i,title,content,posted_at,categories);
            postsResponseDTOS.add(responseDTO);
        }
        usersResDTO.setPosts(postsResponseDTOS);

        return usersResDTO;
    }

    public AuthResponseDTO authenticate(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Users user = usersRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String jwtToken = jwtService.generateToken(user);
        return new AuthResponseDTO(jwtToken);
    }

}
