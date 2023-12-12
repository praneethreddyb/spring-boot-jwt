package com.springboot.jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.jwt.dao.LoginDao;
import com.springboot.jwt.entity.User;


@Service
public class LoginService implements UserDetailsService{

	@Autowired
	private LoginDao loginDao;


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = loginDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		return new org.springframework.security.core.userdetails.User(userName, user.getPassword(),
				new ArrayList<>());
	}
	
}
