package com.springboot.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jwt.entity.User;


public interface LoginDao extends JpaRepository<User, Integer> {
	
	public User findByUserName(String userName);
	
//	@Query(value = "SELECT u FROM user u WHERE u.user_name= :userName")
//	public User findByUserName(@Param("userName") String userName);

}
