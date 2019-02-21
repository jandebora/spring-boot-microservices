package com.microservices.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class UserDto {

	private Long id;
	private @Email String email;
	private @NotEmpty String name;
	private @NotEmpty String surname;
}
