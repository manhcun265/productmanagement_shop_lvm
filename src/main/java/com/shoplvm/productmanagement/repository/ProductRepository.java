package com.shoplvm.productmanagement.repository;

import com.shoplvm.productmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}