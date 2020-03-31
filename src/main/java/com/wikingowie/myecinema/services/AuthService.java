package com.wikingowie.myecinema.services;

import com.wikingowie.myecinema.entities.UserAccount;

public interface AuthService {

    String login(String username, String password);

    void register(UserAccount userAccount);
}
