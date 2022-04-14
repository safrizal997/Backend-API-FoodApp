package com.safrizal.foodservice.repository;

import com.safrizal.foodservice.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {
}
