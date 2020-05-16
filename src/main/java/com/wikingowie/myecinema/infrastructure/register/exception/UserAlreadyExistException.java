package com.wikingowie.myecinema.infrastructure.register.exception;

public class UserAlreadyExistException extends RuntimeException {
	
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
