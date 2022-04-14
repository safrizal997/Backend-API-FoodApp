package com.safrizal.foodservice.service.impl;

import com.safrizal.foodservice.entity.Category;
import com.safrizal.foodservice.model.CreateCategoryReq;
import com.safrizal.foodservice.repository.CategoryRepository;
import com.safrizal.foodservice.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.getContent();
    }

    @Override
    public Category getById(String categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        return category.orElse(new Category());
    }

    @Override
    public Category saveCategory(CreateCategoryReq categoryReq) {
        return categoryRepository
                .save(Category.builder()
                        .id(UUID.randomUUID().toString())
                        .name(categoryReq.getName())
                        .description(categoryReq.getDescription())
                        .build());
    }

    @Override
    public Category updateCategory(String categoryId, CreateCategoryReq categoryReq) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category updatedCategory = category.get();
            updatedCategory.setName(categoryReq.getName());
            updatedCategory.setDescription(categoryReq.getDescription());
            return categoryRepository
                    .save(updatedCategory);
        }
        return null;
    }
}
