package com.wikingowie.myecinema.infrastructure.register.service;

import com.wikingowie.myecinema.domain.user.UserAccount;
import com.wikingowie.myecinema.infrastructure.register.dto.UserRegisterDto;
import com.wikingowie.myecinema.infrastructure.register.exception.TokenExpiredException;
import com.wikingowie.myecinema.infrastructure.register.exception.UserAlreadyExistException;

public interface UserRegisterService {

	UserAccount registerNewUserAccount(UserRegisterDto userRegisterDto) throws UserAlreadyExistException;
	void checkIfTokenExpired(UserAccount userAccount) throws TokenExpiredException;
}
