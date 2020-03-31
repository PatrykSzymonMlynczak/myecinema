package com.wikingowie.myecinema.services.impl;

import com.wikingowie.myecinema.entities.UserAccount;
import com.wikingowie.myecinema.entities.enums.Role;
import com.wikingowie.myecinema.repositories.UserAccountRepository;
import com.wikingowie.myecinema.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.wikingowie.myecinema.config.auth.jwt.JwtTokenGenerator.generateToken;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repository;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(String username, String password) {
        authenticate(username, password);
        return generateToken(username);
    }

    @Override
    public void register(UserAccount userAccount) {
        if (repository.existsByEmail(userAccount.getEmail())) {
            throw new RuntimeException(String.format("Email [%s] already used!", userAccount.getEmail()));
        }
        setupInitialParameters(userAccount);
        repository.save(userAccount);
    }

    private void setupInitialParameters(UserAccount userAccount) {
        userAccount.setRole(Role.USER);
        userAccount.setActivationToken(UUID.randomUUID().toString());
        userAccount.setActivationTokenExpirationDate(LocalDateTime.now().plusHours(1));
        userAccount.setAccountActive(true);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
