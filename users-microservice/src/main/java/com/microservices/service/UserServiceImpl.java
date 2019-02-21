package com.microservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.domain.User;
import com.microservices.dto.UserDto;
import com.microservices.dto.UserDtoCollection;
import com.microservices.repository.UserRepository;
import com.microservices.util.UserTransformer;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserTransformer userTransformer;

	@Override
	public UserDto getUser(Long id) {
		User user = userRepository.getOne(id);
		
		return userTransformer.entityToDto(user);
	}

	@Override
	public UserDtoCollection getAllUsers() {
		List<User> users = userRepository.findAll();
		
		return new UserDtoCollection(users.stream()
				.map(user -> userTransformer.entityToDto(user))
				.collect(Collectors.toList()));
	}

	@Override
	public UserDto addUser(UserDto user) {
		User savedUser = userRepository.save(userTransformer.dtoToEntity(user));
		user.setId(savedUser.getId());
		
		return user;
	}

	@Override
	public UserDto updateUser(UserDto userToUpdate) {
		userRepository.save(userTransformer.dtoToEntity(userToUpdate));
		
		return userToUpdate;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
