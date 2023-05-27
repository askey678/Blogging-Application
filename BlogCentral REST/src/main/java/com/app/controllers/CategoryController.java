package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payloads.ApiResponse;
import com.app.payloads.CategoryDto;
import com.app.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto CreatedcategoryDto = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(CreatedcategoryDto, HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Long catgId) {
		return ResponseEntity.ok(categoryService.getCategoryById(catgId));

	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(categoryService.getAllCategory());
	}

	@PutMapping("/{categoryId}")
	private ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto catgDto,
			@PathVariable Long categoryId) {
		CategoryDto updatedCatg = categoryService.updateCategory(catgDto, categoryId);
		return ResponseEntity.ok(updatedCatg);

	}

	@DeleteMapping("/{categoryId}")
	private ResponseEntity<ApiResponse> deleteUser(@PathVariable("CategoryId") Long catgId) {
		categoryService.deleteCategory(catgId);
		return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);

	}

}
