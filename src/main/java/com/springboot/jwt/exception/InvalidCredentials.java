package com.springboot.jwt.exception;

@SuppressWarnings("serial")
public class InvalidCredentials extends Exception{

	public InvalidCredentials(String message) {
		super(message);
	}
}
