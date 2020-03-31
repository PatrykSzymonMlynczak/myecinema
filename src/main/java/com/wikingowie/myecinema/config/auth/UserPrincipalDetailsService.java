package com.wikingowie.myecinema.config.auth;

import com.wikingowie.myecinema.entities.UserAccount;
import com.wikingowie.myecinema.services.UserAccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private final UserAccountService userAccountService;

    public UserPrincipalDetailsService(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserAccount userAccount = this.userAccountService.findByEmail(email);
        return new UserPrincipal(userAccount);
    }
}
