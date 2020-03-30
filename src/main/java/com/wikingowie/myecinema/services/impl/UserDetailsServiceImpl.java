package com.wikingowie.myecinema.services.impl;

import com.wikingowie.myecinema.entities.UserAccount;
import com.wikingowie.myecinema.repositories.UserAccountRepository;
import com.wikingowie.myecinema.services.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userAccountRepository.getByUsername(s).orElseThrow(() -> new EntityNotFoundException(UserAccount.class, "username", s));
    }
}
