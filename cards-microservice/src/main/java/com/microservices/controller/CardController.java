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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.CardDto;
import com.microservices.dto.CardDtoCollection;
import com.microservices.exception.CardException;
import com.microservices.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardService cardService;
	
	@GetMapping
	public ResponseEntity<CardDtoCollection> getCardsCollection(
			@RequestParam(required = false) Long userId) {
		
		return userId == null ? ResponseEntity.ok(cardService.getAllCards()) : 
			ResponseEntity.ok(cardService.getUserCards(userId));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CardDto> getCard(@PathVariable Long id) {
		
		return ResponseEntity.ok(cardService.getCard(id));
	}
	
	@PostMapping
	public ResponseEntity<CardDto> addCard(@RequestBody CardDto cardDto) throws CardException {
		CardDto savedCard = cardService.addCard(cardDto);
		
		return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CardDto> updateCard(@PathVariable Long id, 
			@RequestBody CardDto cardDto) throws CardException {
		cardDto.setId(id);
		
		return ResponseEntity.ok(cardService.updateCard(cardDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCardById(@PathVariable Long id) {
		cardService.deleteCard(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
