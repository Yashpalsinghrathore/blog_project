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

import com.india.blog.entity.User;
import com.india.blog.paylod.ResponseApi;
import com.india.blog.paylod.UserDto;
import com.india.blog.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto)
	{
		
		
		
		UserDto saveUser = userService.saveUser(userDto);
		
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
		
		
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getById(@PathVariable int id)
	{
		UserDto userDto = userService.getUserById(id);
		
		return ResponseEntity.ok(userDto);
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		
		
		List<UserDto> allUser = userService.getAllUser();
		
		
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
				
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable int id)
	{
		UserDto updateUser = userService.updateUser(userDto, id);
		
		
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseApi deleteUser(@PathVariable int id)
	{
		
		userService.deleteUser(id);
		
		return new ResponseApi("deleted",""+id+"user deleted successfully");
		
		
	}
	
	
	
	
}
