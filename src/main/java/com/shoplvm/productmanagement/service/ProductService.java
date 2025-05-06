package com.shoplvm.productmanagement.service;

import com.shoplvm.productmanagement.dto.ProductRequestDTO;

public interface ProductService {
    Long create(ProductRequestDTO dto);
}