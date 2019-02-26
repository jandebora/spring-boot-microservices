package com.microservices.exception;

public class CardException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CardException() {}
	
	public CardException(String message) {
		super(message);
	}
 
	public CardException(Throwable cause) {
        super(cause.getMessage(), cause, false, false);
	}

    public CardException(String message, Throwable cause) {
        super(message, cause);
    }
}
