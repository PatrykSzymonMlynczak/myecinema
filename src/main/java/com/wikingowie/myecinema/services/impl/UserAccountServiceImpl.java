package com.wikingowie.myecinema.services.impl;

import com.wikingowie.myecinema.entities.UserAccount;
import com.wikingowie.myecinema.repositories.UserAccountRepository;
import com.wikingowie.myecinema.services.UserAccountService;
import com.wikingowie.myecinema.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException(UserAccount.class, "email", email));
    }

    @Override
    public UserAccount findById(long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(UserAccount.class, "id", String.valueOf(id)));
    }
}
