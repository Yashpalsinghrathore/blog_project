package com.india.blog.paylod;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	
	private String title;
	
	
	private String content;
	
    private String imageName;
	
	private Date addedDate;
	
	
	private CategoryDto category;
	
	
	private UserDto user;
}
