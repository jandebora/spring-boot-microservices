package com.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCardException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCardException(String cardNumber) {
		super("Card " + cardNumber + " is not valid");
	}
}
