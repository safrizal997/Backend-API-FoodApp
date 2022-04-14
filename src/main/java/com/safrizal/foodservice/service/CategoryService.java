package com.safrizal.foodservice.service;

import com.safrizal.foodservice.entity.Category;
import com.safrizal.foodservice.model.CreateCategoryReq;

import java.util.List;

public interface CategoryService {

    List<Category> getAll(int size, int page);

    Category getById(String categoryId);

    Category saveCategory(CreateCategoryReq categoryReq);

    Category updateCategory(String categoryId, CreateCategoryReq categoryReq);


}
