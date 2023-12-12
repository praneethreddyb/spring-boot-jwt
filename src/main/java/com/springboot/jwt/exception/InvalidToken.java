package com.springboot.jwt.exception;

@SuppressWarnings("serial")
public class InvalidToken extends Exception{

	public InvalidToken(String message) {
		super(message);
	}
}
