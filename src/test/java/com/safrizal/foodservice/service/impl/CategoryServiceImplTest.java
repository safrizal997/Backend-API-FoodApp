package com.safrizal.foodservice.service.impl;

import com.safrizal.foodservice.entity.Category;
import com.safrizal.foodservice.model.CreateCategoryReq;
import com.safrizal.foodservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceImpl categoryServiceImpl;


    @BeforeEach
    void setUp() {
        categoryServiceImpl = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void getAll() {
        List<Category> categories = categoryServiceImpl.getAll(10, 0);
        assertThat(categories.isEmpty()).isTrue();
    }

    @Test
    void getById() {

        String categoryId = "0f0fe946-30ca-4dad-85d6-073203c61fbd";
        Category byId = categoryServiceImpl.getById(categoryId);
        System.out.println(byId.toString());
        assertThat(byId.getName()).isBlank();

    }

    @Test
    void saveCategory() {
        Category category = categoryServiceImpl.saveCategory(CreateCategoryReq.builder()
                .name("makanan")
                .description("kategori makanan")
                .build());
        assertThat(category.getName()).isEqualTo("makanan");
    }

    @Test
    void updateCategory() {
    }
}