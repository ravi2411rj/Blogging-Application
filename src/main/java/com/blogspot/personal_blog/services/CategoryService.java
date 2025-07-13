package com.blogspot.personal_blog.services;

import com.blogspot.personal_blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto);

    void deleteCategory(Integer categoryId);

}
