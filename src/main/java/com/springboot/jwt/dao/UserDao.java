package com.springboot.jwt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jwt.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUserName(String userName);
	
}
