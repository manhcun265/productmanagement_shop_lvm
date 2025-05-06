package com.shoplvm.productmanagement.controller;

import com.shoplvm.productmanagement.dto.ProductRequestDTO;
import com.shoplvm.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestDTO dto) {
        Long id = productService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Thêm sản phẩm thành công",
                "productId", id
        ));
    }
}

