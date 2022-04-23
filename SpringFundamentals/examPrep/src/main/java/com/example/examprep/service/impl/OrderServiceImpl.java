package com.example.examprep.service.impl;

import com.example.examprep.model.entity.Order;
import com.example.examprep.model.service.OrderServiceModel;
import com.example.examprep.model.view.OrderViewModel;
import com.example.examprep.repository.OrderRepository;
import com.example.examprep.sec.CurrentUser;
import com.example.examprep.service.CategoryService;
import com.example.examprep.service.OrderService;
import com.example.examprep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;


    public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public OrderServiceModel getOrderByName(String name) {
        return orderRepository.getByName(name)
                .map(order -> modelMapper.map(order, OrderServiceModel.class))
                .orElse(null);
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));


        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderOrderByPrice() {

       return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order,OrderViewModel.class))
                .collect(Collectors.toList());


    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
