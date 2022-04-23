package com.example.examprep.model.service;

import com.example.examprep.model.entity.Category;
import com.example.examprep.model.entity.User;
import com.example.examprep.model.enums.CategoryEnum;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {

    private Long id;
    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private User employee;
    private CategoryEnum category;

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Size(min = 3,max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
