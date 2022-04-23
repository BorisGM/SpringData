package com.example.examprep2.repository;

import com.example.examprep2.model.entity.Category;
import com.example.examprep2.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(CategoryEnum name);

}
