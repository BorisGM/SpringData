package com.example.exam.service.impl;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryEnum;
import com.example.exam.repository.CategoryRepository;
import com.example.exam.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryEnum.values()).
                forEach(CategoryEnum -> {
                    Category category = new Category();

                    category.setName(CategoryEnum);

                    switch (CategoryEnum) {
                        case CARGO -> category.setDescription("Cargo description");
                        case BATTLE -> category.setDescription("Battle description");
                        case PATROL -> category.setDescription("Patrol description");

                    }
                    categoryRepository.save(category);
                });


    }
    @Override
    public Category findByName(CategoryEnum categoryEnum) {
        return categoryRepository
                .findByName(categoryEnum)
                .orElse(null);
    }

    @Override
    public Category findByCategoryNameEnum(CategoryEnum categoryEnum) {

        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
