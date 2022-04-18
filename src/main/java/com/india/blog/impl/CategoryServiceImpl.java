package com.india.blog.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.blog.entity.Category;
import com.india.blog.exception.ResourseNotFoundException;
import com.india.blog.paylod.CategoryDto;
import com.india.blog.repo.CategoryRepo;
import com.india.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	CategoryRepo categoryRepo;

	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category save = categoryRepo.save(categoryDtoToCategory(categoryDto));

		return categoryToCategoryDto(save);
	}

	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("category","id",id));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category save = categoryRepo.save(category);
		
		return categoryToCategoryDto(save);
	}

	public void deleteCategory(int id) {
		
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("category","id",id));
		
		categoryRepo.delete(category);	

	}

	public CategoryDto getCategory(int id) {
		
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("category","id",id));
		
		return  categoryToCategoryDto(category) ;
	}

	public List<CategoryDto> getAllCategory() {
		
		List<Category> listOfCategory = categoryRepo.findAll();
		
		List<CategoryDto> collect = listOfCategory.stream().map(category->categoryToCategoryDto(category)).collect(Collectors.toList());
			
		
		return collect;
	}
	
	//converter method
	

	private Category categoryDtoToCategory(CategoryDto categoryDto) {

		return modelMapper.map(categoryDto, Category.class);

	}

	private CategoryDto categoryToCategoryDto(Category category) {
		return modelMapper.map(category, CategoryDto.class);

	}

}
