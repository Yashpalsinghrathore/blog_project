package com.india.blog.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.india.blog.entity.Category;
import com.india.blog.entity.Post;
import com.india.blog.entity.User;
import com.india.blog.exception.ResourseNotFoundException;
import com.india.blog.paylod.PostDto;
import com.india.blog.repo.CategoryRepo;
import com.india.blog.repo.PostRepo;
import com.india.blog.repo.UserRepo;
import com.india.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public PostDto createPost(PostDto postdto,Integer userId,Integer categoryId) {
		
		User user = userRepo.findById(userId).orElseThrow(()->new ResourseNotFoundException("User","user id", userId));
		
		Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourseNotFoundException("category","category Id",categoryId));
		
		Post post = modelMapper.map(postdto,Post.class);
		
		post.setImageName("default.png");
		
		post.setAddedDate(new java.util.Date());
		
		post.setUser(user);
		
		post.setCategory(category);
		
		
		Post savePost = postRepo.save(post);
		
		
		return this.modelMapper.map(savePost,PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer id) {
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer id) {
	
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("category","id",id));
		
		List<Post> findByCategory = this.postRepo.findByCategory(category);
		
		List<PostDto> collect = findByCategory.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	@Override
	public List<PostDto> getPostByUser(Integer id) {
		
		User user = userRepo.findById(id).orElseThrow(()-> new ResourseNotFoundException("User", "id ", id));
		
		List<Post> listPost = this.postRepo.findByUser(user);
		
		List<PostDto> listPostDto = listPost.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
			
		
		
		return listPostDto;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
