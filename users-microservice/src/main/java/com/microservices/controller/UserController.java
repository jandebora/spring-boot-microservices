package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.UserDto;
import com.microservices.dto.UserDtoCollection;
import com.microservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<UserDtoCollection> getAllUsers() {
		
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
		UserDto user = userService.getUser(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
		
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
		
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
} 
