package com.microservices.service;

import com.microservices.dto.CardDto;
import com.microservices.dto.CardDtoCollection;
import com.microservices.exception.CardException;

public interface CardService {

	public CardDto getCard(Long id);
	public CardDtoCollection getAllCards();
	public CardDto addCard(CardDto cardDto) throws CardException;
	public CardDto updateCard(CardDto cardDto) throws CardException;
	public void deleteCard (Long id);
}
