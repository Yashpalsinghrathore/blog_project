package com.india.blog.paylod;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min =4,message = "size should be grater then 4")
	private String name;
	
	@Email(message = "email address not valid")
	private String email;
	
	//@Pattern(regexp ="")
	@NotEmpty
	private String  password;
	
	@NotEmpty
	private String about;
}
