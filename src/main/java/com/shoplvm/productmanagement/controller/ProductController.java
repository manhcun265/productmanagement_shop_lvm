package com.shoplvm.productmanagement.controller;

import com.shoplvm.productmanagement.dto.request.CreateProductRequest;
import com.shoplvm.productmanagement.dto.response.CreateProductResponse;
import com.shoplvm.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping
  public ResponseEntity<CreateProductResponse> createProduct(
      @Valid @RequestBody CreateProductRequest dto) {
    Long id = productService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            CreateProductResponse.builder()
                .message("Thêm sản phẩm thành công")
                .productId(id)
                .build());
  }
}
