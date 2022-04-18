package com.india.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.india.blog.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
