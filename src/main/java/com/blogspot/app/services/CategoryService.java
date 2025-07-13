package com.blogspot.app.services;

import com.blogspot.app.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);

    void deleteCategory(Integer categoryId);

}
