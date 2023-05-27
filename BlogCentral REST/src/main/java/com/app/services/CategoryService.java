package com.app.services;

import java.util.List;

import com.app.payloads.CategoryDto;

public interface CategoryService {

	// create
	public CategoryDto createCategory(CategoryDto categoryDto);

	// update
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);

	// delete
	public void deleteCategory(Long categoryId);

	// getbyId
	public CategoryDto getCategoryById(Long categoryId);

	// getAllCategory
	public List<CategoryDto> getAllCategory();

}
