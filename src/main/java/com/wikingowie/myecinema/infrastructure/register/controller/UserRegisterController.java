package com.wikingowie.myecinema.infrastructure.register.controller;

import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.domain.user.UserAccountRepository;
import com.wikingowie.myecinema.infrastructure.register.dto.UserRegisterDto;
import com.wikingowie.myecinema.infrastructure.register.exception.TokenExpiredException;
import com.wikingowie.myecinema.infrastructure.register.exception.UserAlreadyExistException;
import com.wikingowie.myecinema.infrastructure.register.listener.RegistrationEvent;
import com.wikingowie.myecinema.infrastructure.register.service.UserRegisterService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserRegisterController {
	
	private final UserRegisterService userRegisterService;
	private final UserAccountRepository accountRepository;
	private final ApplicationEventPublisher applicationEventPublisher;
	
	public UserRegisterController(UserRegisterService userRegisterService,
			UserAccountRepository accountRepository,
		    ApplicationEventPublisher applicationEventPublisher) {
		this.userRegisterService = userRegisterService;
		this.accountRepository = accountRepository;
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	@PostMapping("/user/registration")
	public ResponseEntity<String> registerUserAccount(@Valid @RequestBody UserRegisterDto userRegisterDto,
													  HttpServletRequest request) {
		try {
	        UserAccount registered = userRegisterService.registerNewUserAccount(userRegisterDto);
	        applicationEventPublisher.publishEvent(new RegistrationEvent(registered,
					request.getRequestURL().toString().replaceAll(request.getRequestURI(), "")));
	    } catch (UserAlreadyExistException uaeEx) {
	        return ResponseEntity.badRequest().body(uaeEx.getMessage());
	    }
		return ResponseEntity.ok().body("User created.");
	}

	@GetMapping("/user/confirm-account")
	public ResponseEntity<String> confirmRegistration
			(@RequestParam("token") String token) {

		Optional<UserAccount> account = accountRepository.findByActivationToken(token);
		if (!account.isPresent()) {
			throw new UsernameNotFoundException("User Account not found.");
		}
		UserAccount userAccount = account.get();
		try {
			userRegisterService.checkIfTokenExpired(userAccount);
		} catch (TokenExpiredException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		userAccount.setAccountActive(true);
		accountRepository.save(userAccount);
		return ResponseEntity.ok().body("User has been activated.");
	}

}
