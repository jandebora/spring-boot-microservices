package com.microservices.service.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.dto.CardDto;
import com.microservices.dto.CardDtoCollection;

@FeignClient(name = "cards", fallback = CardServiceFallback.class)
public interface CardService {

	@GetMapping("/cards")
	public ResponseEntity<CardDtoCollection> getUserCards(@RequestParam Long userId);
	
	@PostMapping("/cards")
	public ResponseEntity<CardDto> addCard(@RequestBody CardDto cardDto);
}
