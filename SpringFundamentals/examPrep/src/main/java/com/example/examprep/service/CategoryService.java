package com.example.examprep.service;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.enums.CategoryEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryEnum categoryNameEnum);
}
