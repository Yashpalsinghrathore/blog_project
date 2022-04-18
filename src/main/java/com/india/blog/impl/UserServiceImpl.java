package com.india.blog.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.loader.custom.CollectionFetchReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.blog.entity.User;
import com.india.blog.exception.ResourseNotFoundException;
import com.india.blog.paylod.UserDto;
import com.india.blog.repo.UserRepo;
import com.india.blog.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		
		User user = userRepo.save(userDtoToUser(userDto));
		
		return userToUserDto(user);
		
		
	}

	


	@Override
	public List<UserDto> getAllUser() {
		
		List<User> listUser = userRepo.findAll();
		
		List<UserDto> listUserDto = listUser.stream().map(user->userToUserDto(user)).collect(Collectors.toList());
		
		return listUserDto;
	}



	@Override
	public UserDto getUserById(int id) {
		
		User user = userRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", "id ", id));
		
		return userToUserDto(user);
	}



	@Override
	public UserDto updateUser(UserDto userDto,int id) {
		
		User user = userRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", "id ", id));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		
		User updateUser = userRepo.save(user);
		
		
		
		
		
		return userToUserDto(updateUser);
	}



	@Override
	public void deleteUser(int id) {
		
		User user = userRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", "id ", id));
		
		userRepo.delete(user);
		
		log.info("user deleted successfully");
		
		
	}
	
	//converted methods
	
	public User userDtoToUser(UserDto userDto)
	{
		
		/*
		 * User user = new User(); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setAbout(userDto.getAbout());
		 */
		
		User user = this.modelMapper.map(userDto,User.class);
		
		
		return user;
		
		
	}
	
	public UserDto userToUserDto(User user)
	{
		
		/*
		 * UserDto userDto = new UserDto();
		 * 
		 * userDto.setId(user.getId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setAbout(user.getAbout());
		 */
		
		UserDto userDto = modelMapper.map(user,UserDto.class);
		
		return userDto;
		
	}


}
