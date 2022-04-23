package com.example.exam.service;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

     Category findByName(CategoryEnum categoryEnum);

    Category findByCategoryNameEnum(CategoryEnum categoryEnum);
}
