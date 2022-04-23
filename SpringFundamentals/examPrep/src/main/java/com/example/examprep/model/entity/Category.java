package com.example.examprep.model.entity;

import com.example.examprep.model.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnum name;
    private Integer neededTime;


    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }
    @Column(nullable = false)
    public Integer getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }
}
