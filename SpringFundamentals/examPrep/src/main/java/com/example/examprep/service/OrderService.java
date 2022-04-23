package com.example.examprep.service;

import com.example.examprep.model.service.OrderServiceModel;
import com.example.examprep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    OrderServiceModel getOrderByName(String name);

    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPrice();

    void readyOrder(Long id);
}
