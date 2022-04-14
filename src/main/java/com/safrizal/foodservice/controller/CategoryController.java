package com.safrizal.foodservice.controller;

import com.safrizal.foodservice.entity.Category;
import com.safrizal.foodservice.model.CreateCategoryReq;
import com.safrizal.foodservice.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/category", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Category-Endpoint", description = "All action for category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll(@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "0") int page) {
        return categoryService.getAll(size, page);
    }

    @GetMapping(path = "/{categoryId}")
    public Category getById(@PathVariable String categoryId) {
        return categoryService.getById(categoryId);
    }

    @PostMapping
    public Category saveCategory(@Valid @RequestBody CreateCategoryReq categoryReq) {
        return categoryService.saveCategory(categoryReq);
    }

    @PutMapping(path = "/{categoryId}")
    public Category updateCategory(@PathVariable String categoryId, @Valid @RequestBody CreateCategoryReq categoryReq) {
        return categoryService.updateCategory(categoryId, categoryReq);
    }
}
