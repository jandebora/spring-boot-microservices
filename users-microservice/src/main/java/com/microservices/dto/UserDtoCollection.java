package com.microservices.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter
public class UserDtoCollection {

	private Collection<UserDto> users;
	
	@JsonIgnoreProperties("cards")
	public Collection<UserDto> getUsers() {
		return users;
	}
}
