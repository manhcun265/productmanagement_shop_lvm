package com.shoplvm.productmanagement.config;

import com.shoplvm.productmanagement.model.Category;
import com.shoplvm.productmanagement.model.User;
import com.shoplvm.productmanagement.repository.CategoryRepository;
import com.shoplvm.productmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void run(String... args) {
        // Nếu chưa có category thì tạo mới
        if (categoryRepository.count() == 0) {
            Category category = new Category();
            category.setName("Điện thoại");
            categoryRepository.save(category);
            System.out.println("🌱 Tạo dữ liệu mẫu: Category 'Điện thoại'");
        }

        // Nếu chưa có user thì tạo mới
        if (userRepository.count() == 0) {
            User user = new User();
            user.setUsername("admin");
            user.setEmail("admin@example.com");
            user.setPasswordHash("admin123"); // chỉ để test, không cần mã hoá
            user.setRole("ADMIN");
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
            System.out.println("🌱 Tạo dữ liệu mẫu: User 'admin'");
        }
    }
}
