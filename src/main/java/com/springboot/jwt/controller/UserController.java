package com.springboot.jwt.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.jwt.entity.User;
import com.springboot.jwt.exception.MessageException;
import com.springboot.jwt.model.UserDto;
import com.springboot.jwt.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<HashMap<String, Object>> saveUser(@RequestBody UserDto user) throws Exception {
		HashMap<String, Object> res=new HashMap<>();
		boolean success=false;
		try {
			userService.getByUserName(user.getUserName());
		}catch (MessageException e) {
			success=true;
		}
		String message="";
		if(success){
			res.put("data", userService.save(user));
			message="Successfully registered";
		}else {
			success=false;
			message="User with the user name already exists";
		}
		res.put("success", success);
		res.put("message", message);
		return new ResponseEntity<HashMap<String,Object>>(res, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/users")
	public ResponseEntity<HashMap<String, Object>> getAllUsers() throws Exception {
		HashMap<String, Object> res=new HashMap<>();
		List<User> data=userService.getAllUsers();
		res.put("success", true);
		res.put("data", data);
		return new ResponseEntity<HashMap<String,Object>>(res, HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<HashMap<String, Object>> getUserById(@PathVariable Integer id) throws Exception {
		HashMap<String, Object> res=new HashMap<>();
		User data=userService.getUserById(id);
		res.put("success", true);
		res.put("data", data);
		return new ResponseEntity<HashMap<String,Object>>(res, HttpStatus.OK);
	}

}
