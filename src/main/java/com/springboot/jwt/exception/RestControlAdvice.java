package com.springboot.jwt.exception;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.MalformedJwtException;

@RestControllerAdvice
public class RestControlAdvice {
	
	
	@ExceptionHandler(value = InvalidCredentials.class)
	public ResponseEntity<HashMap<String, Object>> unauthorizedException(HttpServletRequest request,InvalidCredentials exception){
		HashMap<String, Object> res=new HashMap<>();
		res.put("success", false);
		res.put("message", "Invalid Credentials");
		return new ResponseEntity<HashMap<String,Object>>(res,HttpStatus.OK);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<HashMap<String, Object>> exception(HttpServletRequest request,Exception exception){
		HashMap<String, Object> res=new HashMap<>();
		res.put("success", false);
		res.put("message", "Internal Server Error");
		return new ResponseEntity<HashMap<String,Object>>(res,HttpStatus.OK);
	}
	
	@ExceptionHandler(value = MessageException.class)
	public ResponseEntity<HashMap<String, Object>> messageException(HttpServletRequest request,MessageException exception){
		HashMap<String, Object> res=new HashMap<>();
		res.put("success", false);
		res.put("message", exception.getMessage());
		return new ResponseEntity<HashMap<String,Object>>(res,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value = MalformedJwtException.class)
	public ResponseEntity<HashMap<String, Object>> malformedJwtException(HttpServletRequest request,MalformedJwtException exception){
		HashMap<String, Object> res=new HashMap<>();
		res.put("success", false);
		res.put("message", "Invalid Token");
		return new ResponseEntity<HashMap<String,Object>>(res,HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(value = InvalidToken.class)
	public ResponseEntity<HashMap<String, Object>> ioException(HttpServletRequest request,InvalidToken exception){
		HashMap<String, Object> res=new HashMap<>();
		res.put("success", false);
		res.put("message", exception.getMessage());
		return new ResponseEntity<HashMap<String,Object>>(res,HttpStatus.UNAUTHORIZED);
	}

}
