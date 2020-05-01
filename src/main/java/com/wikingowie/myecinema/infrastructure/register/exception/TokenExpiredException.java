package com.wikingowie.myecinema.infrastructure.register.exception;

public class TokenExpiredException extends Exception {

    public TokenExpiredException(String message) {
        super(message);
    }

}
