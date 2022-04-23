package com.example.exam.model.binding;

import com.example.exam.model.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddShipBindingModel {

    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryEnum  category;

    public AddShipBindingModel() {
    }

    @NotBlank(message = "Name can not be empty")
    @Size(min = 3,max = 20,message = "Name must be between 2 and 10")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive(message = "Power must be positive")
    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }
    @Positive(message = "Power must be positive")
    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
    @NotNull(message = "Category must not be empty!")
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
