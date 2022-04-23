package com.example.examprep.repository;

import com.example.examprep.model.entity.Order;
import com.example.examprep.service.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> getByName(String name);

    List<Order> findAllByOrderByPriceDesc();
}
