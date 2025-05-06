package com.shoplvm.productmanagement.service.impl;

import com.shoplvm.productmanagement.dto.ProductRequestDTO;
import com.shoplvm.productmanagement.model.*;
import com.shoplvm.productmanagement.repository.*;
import com.shoplvm.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository imageRepository;
    private final UserRepository userRepository;
    private final ProductStatusLogRepository statusLogRepository;

    @Override
    public Long create(ProductRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Danh mục không tồn tại"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        product.setDetail(dto.getDetail() != null ? dto.getDetail().toString() : null);
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);

        for (String url : dto.getImageUrls()) {
            ProductImage image = new ProductImage();
            image.setProduct(product);
            image.setImageUrl(url);
            imageRepository.save(image);
        }

        ProductStatusLog statusLog = new ProductStatusLog();
        statusLog.setProduct(product);
        statusLog.setUser(user);
        statusLog.setStatus("CREATED");
        statusLog.setLogDate(new Timestamp(System.currentTimeMillis()));
        statusLogRepository.save(statusLog);

        return product.getId();
    }
}
