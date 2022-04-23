package com.example.examprep2.service;

import com.example.examprep2.model.enums.CategoryEnum;
import com.example.examprep2.model.service.ProductServiceModel;
import com.example.examprep2.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryEnum);

    void buyById(Long id);

    void buyAll();
}
