package com.india.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.india.blog.entity.Category;
import com.india.blog.entity.Post;
import com.india.blog.entity.User;

public interface PostRepo extends JpaRepository<Post,Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
