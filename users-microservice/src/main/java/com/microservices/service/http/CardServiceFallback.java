package com.microservices.service.http;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.ResourceAccessException;

import com.microservices.dto.CardDto;
import com.microservices.dto.CardDtoCollection;

@Component
public class CardServiceFallback implements CardService {

	@Override
	@GetMapping("/cards")
	public ResponseEntity<CardDtoCollection> getUserCards(Long userId) {
		throw new ResourceAccessException("Cannot acces to cards");
	}

	@Override
	@PostMapping("/cards")
	public ResponseEntity<CardDto> addCard(CardDto cardDto) {
		throw new ResourceAccessException("Cannot acces to cards microservice");
	}

}
