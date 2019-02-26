package com.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardTypeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CardTypeNotFoundException(String cardNumber) {
		super("Could not find card type for " + cardNumber);
	}
}
