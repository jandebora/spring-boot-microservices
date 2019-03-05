package com.microservices.service;

import com.microservices.dto.UserCardCollectionDto;
import com.microservices.dto.UserDto;
import com.microservices.dto.UserDtoCollection;

public interface UserService {

	public UserDto getUser(Long id);
	public UserCardCollectionDto getUserAndCards(Long id);
	public UserDtoCollection getAllUsers();
	public UserDto addUser(UserDto user);
	public UserDto updateUser(UserDto userToUpdate);
	public void deleteUser(Long id);
}
