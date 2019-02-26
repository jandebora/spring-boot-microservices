package com.microservices.util;

import org.springframework.stereotype.Component;

import com.microservices.domain.User;
import com.microservices.dto.UserDto;

@Component
public class UserTransformer implements CustomTransformer<User, UserDto> {

	@Override
	public UserDto entityToDto(User entity) {
		return new UserDto(entity.getId(), entity.getEmail(), 
				entity.getName(), entity.getSurname());
	}

	@Override
	public User dtoToEntity(UserDto dto) {
		return new User(dto.getId(), dto.getEmail(),
				dto.getName(), dto.getSurname(), null, null);
	}

}
