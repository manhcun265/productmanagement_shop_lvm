package com.shoplvm.productmanagement.service;

import com.shoplvm.productmanagement.dto.request.CreateProductRequest;

public interface ProductService {
    Long create(CreateProductRequest dto);
}