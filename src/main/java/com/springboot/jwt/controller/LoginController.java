package com.springboot.jwt.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jwt.config.JwtTokenUtil;
import com.springboot.jwt.exception.InvalidCredentials;
import com.springboot.jwt.model.Login;
import com.springboot.jwt.service.LoginService;
import com.springboot.jwt.service.UserService;



@RestController
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/login")
	private ResponseEntity<HashMap<String,Object>> login(@RequestBody Login login) throws Exception{
		HashMap<String, Object> res=new HashMap<>();
		authenticate(login.getUserName(), login.getPassword());
		UserDetails userDetails= loginService.loadUserByUsername(login.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		res.put("success", true);
		res.put("token", token);
		res.put("data",userService.getByUserName(login.getUserName()));
		return ResponseEntity.ok(res);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new InvalidCredentials("INVALID_CREDENTIALS");
		}
	}
	
}
