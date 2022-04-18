package com.india.blog.service;

import java.util.List;

import com.india.blog.entity.Post;
import com.india.blog.paylod.PostDto;

public interface PostService {

	//create
	
	public PostDto createPost(PostDto postdto,Integer userId,Integer categoryId);
	
	//update
	
	public PostDto updatePost(PostDto postDto,Integer id);
	
	//delete
	
	public void deletePost(Integer id);
	
	//getAllPost
	
	public List<PostDto> getAllPost();
	
	//get single post
	
	public PostDto getPostById(Integer id);
	
	//get posts by category
	
	public List<PostDto> getPostsByCategory(Integer id);
	
	//get all posts by user
	
	public List<PostDto> getPostByUser(Integer id);
	
	//search posts
	
	List<Post> searchPost(String keyword);
	
	
	
}
