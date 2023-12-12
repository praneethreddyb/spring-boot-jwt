package com.springboot.jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.jwt.dao.UserDao;
import com.springboot.jwt.entity.User;
import com.springboot.jwt.exception.MessageException;
import com.springboot.jwt.model.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public User save(UserDto userDto) {
		return userDao.save(new User(userDto.getName(),userDto.getUserName(),userDto.getPhone(),
				bcryptEncoder.encode(userDto.getPassword())));
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public User getUserById(Integer id) throws MessageException {
		Optional<User> user=userDao.findById(id);
		if(!user.isPresent()) {
			throw new MessageException("User not found");
		}
		return user.get();
	}
	
	public User getByUserName(String userName) throws MessageException {
		Optional<User> user=userDao.findByUserName(userName);
		if(!user.isPresent()) {
			throw new MessageException("User not found");
		}
		return user.get();
	}

}
