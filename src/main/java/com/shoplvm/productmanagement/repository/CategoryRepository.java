package com.shoplvm.productmanagement.repository;

import com.shoplvm.productmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
