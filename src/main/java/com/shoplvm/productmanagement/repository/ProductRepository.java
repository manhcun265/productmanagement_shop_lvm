package com.shoplvm.productmanagement.repository;

import com.shoplvm.productmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}