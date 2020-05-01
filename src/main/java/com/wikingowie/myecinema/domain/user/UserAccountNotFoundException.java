package com.wikingowie.myecinema.domain.user;

public class UserAccountNotFoundException extends Exception {
    public UserAccountNotFoundException(String message) {
        super(message);
    }
}
