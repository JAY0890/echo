package com.org.echo.Service;

import com.org.echo.DTO.CategoryDTO;
import com.org.echo.Entities.Category;
import com.org.echo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(CategoryDTO categoryDTO){

        Optional<Category> category=categoryRepository.findByCategoryName(categoryDTO.getCategory_name());

        if(category.isEmpty()){
            Category c=new Category();
            c.setCategoryName(categoryDTO.getCategory_name());
            return categoryRepository.save(c);
        }else{
            throw new RuntimeException("this category already exist");
        }

    }

    public List<Category> getall() {
        return categoryRepository.findAll();
    }
}
