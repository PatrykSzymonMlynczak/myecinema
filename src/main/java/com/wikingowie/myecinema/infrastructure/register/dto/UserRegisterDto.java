package com.wikingowie.myecinema.infrastructure.register.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wikingowie.myecinema.domain.user.UserAccountDto;
import com.wikingowie.myecinema.domain.user.UserDataDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterDto {

	@NotNull
	@NotEmpty
	private String username;
	@Email
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String city;

	private String postcode;

	@NotNull
	@NotEmpty
	private String address;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;


}
