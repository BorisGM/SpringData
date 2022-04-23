package com.example.examprep2.service.impl;

import com.example.examprep2.model.entity.Category;
import com.example.examprep2.model.enums.CategoryEnum;
import com.example.examprep2.repository.CategoryRepository;
import com.example.examprep2.service.CategoryService;
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

//                    switch (CategoryEnum) {
//                        case HOUSEHOLD -> category.setNeededTime(10);
//                        case FOOD -> category.setNeededTime(2);
//                        case DRINK -> category.setNeededTime(1);
//                        case OTHER -> category.setNeededTime(5);
//                    }
                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByName(CategoryEnum categoryEnum) {
        return categoryRepository.findByName(categoryEnum)
                .orElse(null);

    }
}
