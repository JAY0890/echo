package com.org.echo.Repository;

import com.org.echo.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

    Optional<Users> findByEmail(String email);


    @Query("SELECT DISTINCT u FROM Users u "
         + "LEFT JOIN FETCH u.posts p "
         + "LEFT JOIN FETCH p.categories "
         + "WHERE u.id = :id")
    Optional<Users> findByIdWithPostsAndCategories(int id);
}
