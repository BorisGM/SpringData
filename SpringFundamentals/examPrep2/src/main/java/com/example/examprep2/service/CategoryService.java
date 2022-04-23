package com.example.examprep2.service;

import com.example.examprep2.model.entity.Category;
import com.example.examprep2.model.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryEnum categoryEnum);
}
