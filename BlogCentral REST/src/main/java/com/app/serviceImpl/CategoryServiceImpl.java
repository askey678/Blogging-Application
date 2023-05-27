package com.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exceptions.ResourceNotFoundException;
import com.app.payloads.CategoryDto;
import com.app.pojos.Category;
import com.app.repositories.CategoryRepo;
import com.app.services.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	public CategoryRepo categoryRepo;

	@Autowired
	public ModelMapper modelMapper;

	public Category dtoToCategory(CategoryDto catgDto) {
		return modelMapper.map(catgDto, Category.class);
	}

	public CategoryDto CategoryToDto(Category catg) {
		return modelMapper.map(catg, CategoryDto.class);
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = dtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(category);

		return CategoryToDto(savedCategory);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = categoryRepo.save(category);
		return CategoryToDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return CategoryToDto(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> allCategory = categoryRepo.findAll();
		List<CategoryDto> allCategoryDto = allCategory.stream().map((category) -> CategoryToDto(category))
				.collect(Collectors.toList());
		return allCategoryDto;
	}

}
