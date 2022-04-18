package com.india.blog.paylod;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	@NotNull
	@Size(min = 4,message = "size should be grater then 4")
	private String categoryTitle;
	
	@NotNull
	@Size(min = 4,message = "size should be grater then 4")
	private String categoryDescription;
}
