package com.wikingowie.myecinema.services.impl;

import com.wikingowie.myecinema.entities.UserAccount;
import com.wikingowie.myecinema.repositories.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class GenerateDataService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public void generate() {

        UserAccount userAccount = new UserAccount().builder()
                .username("admin")
                .email("admin@wp.pl")
                .password(passwordEncoder.encode("admin123"))
                .role("ROLE_ADMIN")
                .version(1)
                .creationDate(LocalDate.now())
                .lastUpdateDate(LocalDate.now())
                .build();

        UserAccount userAccount2 = new UserAccount().builder()
                .username("user")
                .email("user@wp.pl")
                .password(passwordEncoder.encode("user123"))
                .role("ROLE_USER")
                .version(1)
                .creationDate(LocalDate.now())
                .lastUpdateDate(LocalDate.now())
                .build();

        userAccountRepository.save(userAccount);
        userAccountRepository.save(userAccount2);
    }
}
