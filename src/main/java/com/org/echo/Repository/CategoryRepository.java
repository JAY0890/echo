package com.org.echo.Repository;

import com.org.echo.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findByCategoryName (String categoryName);
}
