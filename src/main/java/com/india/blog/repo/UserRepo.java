package com.india.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.india.blog.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
