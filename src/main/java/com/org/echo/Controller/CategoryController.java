package com.org.echo.Controller;

import com.org.echo.DTO.CategoryDTO;
import com.org.echo.Entities.Category;
import com.org.echo.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody @Valid CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping("/getall")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getall(){
        return categoryService.getall();
    }
}
