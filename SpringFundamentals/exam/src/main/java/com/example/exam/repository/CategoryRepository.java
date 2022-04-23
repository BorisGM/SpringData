package com.example.exam.repository;

import com.example.exam.model.entity.Category;
import com.example.exam.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(CategoryEnum categoryEnum);
}
