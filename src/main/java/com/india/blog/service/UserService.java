package com.india.blog.service;

import java.util.List;

import com.india.blog.entity.User;
import com.india.blog.paylod.UserDto;


public interface UserService {

	public UserDto saveUser(UserDto userDto);
	
	public List<UserDto> getAllUser();
	
	public UserDto getUserById(int id);
	
	public UserDto updateUser(UserDto userDto,int id);
	
	public void deleteUser(int id);
	
}
