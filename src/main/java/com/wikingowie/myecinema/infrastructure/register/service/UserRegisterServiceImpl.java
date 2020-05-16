package com.wikingowie.myecinema.infrastructure.register.service;

import com.wikingowie.myecinema.domain.user.*;
import com.wikingowie.myecinema.infrastructure.exception.EntityNotFoundException;
import com.wikingowie.myecinema.infrastructure.register.dto.UserRegisterDto;
import com.wikingowie.myecinema.infrastructure.register.exception.TokenExpiredException;
import com.wikingowie.myecinema.infrastructure.register.exception.UserAlreadyExistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
    private final UserAccountService userAccountService;
    private final UserAccountRepository userAccountRepository;
	private final PasswordEncoder passwordEncoder;
     
    public UserRegisterServiceImpl(UserAccountService userAccountService,
    		UserAccountRepository userAccountRepository,
			PasswordEncoder passwordEncoder) {
		this.userAccountService = userAccountService;
		this.userAccountRepository = userAccountRepository;
		this.passwordEncoder = passwordEncoder;
	}

    @Override
    public UserAccount registerNewUserAccount(UserRegisterDto userRegisterDto) 
      throws UserAlreadyExistException {
         
        if (emailExist(userRegisterDto.getEmail())) {
            throw new UserAlreadyExistException(
            		String.format("Account with given email %s already exists.", userRegisterDto.getEmail()));
        }
        UserAccount userAccount = buildUserAccount(userRegisterDto);
		return userAccountRepository.save(userAccount);
        
    }

    @Override
	public void checkIfTokenExpired(UserAccount userAccount) throws TokenExpiredException {
		if(LocalDateTime.now().isAfter(userAccount.getActivationTokenExpirationDate())) {
			throw new TokenExpiredException("Given token is expired");
		}
	}

    private boolean emailExist(String email) {
    	try {
			return userAccountService.findByEmail(email) != null;
		} catch(EntityNotFoundException e) {
    		return false;
		}
    }
    
    private UserAccount buildUserAccount(UserRegisterDto userRegisterDto) {
    	UserData userData = UserData.builder()
    			.firstName(userRegisterDto.getFirstName())
    			.lastName(userRegisterDto.getLastName())
    			.city(userRegisterDto.getCity())
    			.adress(userRegisterDto.getAddress())
    			.postcode(userRegisterDto.getPostcode())
    			.dateOfBirth(userRegisterDto.getDateOfBirth())
    			.build();
    	
    	return UserAccount.builder()
    			.userData(userData)
    			.activationDate(LocalDateTime.now())
    			.activationToken(UUID.randomUUID().toString())
				.activationTokenExpirationDate(LocalDateTime.now().plusDays(1))
    			.creationDate(LocalDateTime.now().plusDays(1).toLocalDate())
    			.creationDate(LocalDate.now())
    			.email(userRegisterDto.getEmail())
    			.password(passwordEncoder.encode(userRegisterDto.getPassword()))
    			.isAccountActive(false)
    			.isAccountBlocked(false)
    			.isPremiumAccount(false)
    			.registrationDate(LocalDateTime.now())
    			.username(userRegisterDto.getUsername())
				.userRole(UserRole.USER)
    			.build();
    }
    
}
