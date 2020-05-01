package com.wikingowie.myecinema.infrastructure.register.exception;

public class UserAlreadyExistException extends Exception {
	
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
