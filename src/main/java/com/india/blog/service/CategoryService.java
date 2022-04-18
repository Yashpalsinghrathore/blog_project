package com.india.blog.service;

import java.util.List;

import com.india.blog.paylod.CategoryDto;

public interface CategoryService {

	
	//create
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer id);
	
	//delete
	
	public void deleteCategory(int id);
	
	//get
	
	public CategoryDto getCategory(int id);
	
	//getAll
	
	public List<CategoryDto> getAllCategory();
	
}
