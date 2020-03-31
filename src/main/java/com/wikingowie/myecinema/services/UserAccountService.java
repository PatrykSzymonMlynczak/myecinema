package com.wikingowie.myecinema.services;

import com.wikingowie.myecinema.entities.UserAccount;

public interface UserAccountService {

    UserAccount findByEmail(String email);

    UserAccount findById(long id);
}
