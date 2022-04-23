package com.example.examprep2.service.impl;

import com.example.examprep2.model.entity.Product;
import com.example.examprep2.model.enums.CategoryEnum;
import com.example.examprep2.model.service.ProductServiceModel;
import com.example.examprep2.model.view.ProductViewModel;
import com.example.examprep2.repository.ProductRepository;
import com.example.examprep2.service.CategoryService;
import com.example.examprep2.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {

        Product product = modelMapper.map(productServiceModel, Product.class);
//       Сетване на категория понеже не може да се намапи от модел мапера за това я вадя от сървиса
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {

//      При покупка на всички за да не връшаме нълл му задавам 0
        if (productRepository.findTotalProductsSum() == null){
            return new BigDecimal(0);
        }

        return productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryEnum categoryEnum) {
        return productRepository.findAllByCategory_Name(categoryEnum)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
