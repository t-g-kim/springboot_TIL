package com.example.admin.repository;

import com.example.admin.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Query Method
    // select * from category where type = "???"
    Optional<Category> findByType(String type);
}
