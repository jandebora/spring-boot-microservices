package com.microservices.dto;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserCardCollectionDto extends UserDto {

	private Collection<CardDto> cards;
	
	public UserCardCollectionDto(Long id, String email, String name, 
			String surname, Collection<CardDto> cards) {
		super(id, email, name, surname);
		this.cards = cards;
	}
	
	public UserCardCollectionDto(UserDto user, Collection<CardDto> cards) {
		this(user.getId(), user.getEmail(), user.getName(), user.getSurname(), cards);
	}
}
