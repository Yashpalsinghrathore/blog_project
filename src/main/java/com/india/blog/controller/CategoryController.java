package com.india.blog.controller;

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

import com.india.blog.paylod.CategoryDto;
import com.india.blog.paylod.ResponseApi;
import com.india.blog.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;

	//create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		
		
		return new ResponseEntity<CategoryDto>(createCategory ,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto ,@PathVariable("id") int id )
	{
		
		CategoryDto updateCategory = categoryService.updateCategory(categoryDto,id);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	
	//delete
	
	@DeleteMapping("/{id}")
	public ResponseApi deleteCategory(@PathVariable("id") int id)
	{
		
		categoryService.deleteCategory(id);
		
		return new ResponseApi("category  "+id+" deleted successfulle",HttpStatus.OK.toString());
	}
	
	//get
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int id)
	{
		
		CategoryDto category = categoryService.getCategory(id);
	
		return ResponseEntity.ok(category);
	}
	
	
	
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		
		return ResponseEntity.ok(allCategory);
		
	}
	
}

