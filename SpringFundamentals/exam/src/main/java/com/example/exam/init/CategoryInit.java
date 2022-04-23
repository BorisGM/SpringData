package com.example.exam.init;

import com.example.exam.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public CategoryInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}
