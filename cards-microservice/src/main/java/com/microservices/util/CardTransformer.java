package com.microservices.util;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.microservices.domain.Card;
import com.microservices.domain.CardType;
import com.microservices.dto.CardDto;
import com.microservices.exception.CardException;
import com.microservices.exception.CardTypeNotFoundException;
import com.microservices.exception.InvalidCardException;

@Component
public class CardTransformer implements CustomTransformer<Card, CardDto> {
	
	private final EnumSet<CardType> cardTypes = EnumSet.allOf((CardType.class));
	
	private final String cardRegex = "^(?:(?<VISA>4[0-9]{12}(?:[0-9]{3})?)|" +
	        "(?<MASTERCARD>5[1-5][0-9]{14})|" +
	        "(?<DISCOVER>6(?:011|5[0-9]{2})[0-9]{12})|" +
	        "(?<AMERICANEXPRESS>3[47][0-9]{13})|" +
	        "(?<DINERSCLUB>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
	        "(?<JCB>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
	
	private Pattern pattern = Pattern.compile(cardRegex);

	@Override
	public CardDto entityToDto(Card entity) {
		return new CardDto(entity.getId(), entity.getUserId(), 
				entity.getMaskedPan(), entity.getType());
	}

	@Override
	public Card dtoToEntity(CardDto dto) throws CardException {
		String cardNumber = dto.getCardNumber();
		
		if (luhnValidation(cardNumber)) {
			CardType cardType = getCardType(cardNumber);
			return new Card(dto.getId(), dto.getUserId(), 
					dto.getCardNumber().substring(0, 6), cardType, 
					maskPan(cardNumber), null, null);
		}
		throw new CardException(new InvalidCardException(cardNumber));
		
	}
	
	private Boolean luhnValidation(String cardNumber) {
		int sum = 0;
		boolean alternate = false;
		
		for (int i = cardNumber.length() - 1; i >= 0; i--) {
			int digit = Integer.parseInt(cardNumber.substring(i, i + 1));
			if (alternate) {
				digit *= 2;
				if (digit > 9)
					digit = (digit % 10) + 1;
			}
			sum += digit;
			alternate = !alternate;
		}
		
		return sum % 10 == 0;
	}
	
	private CardType getCardType(String cardNumber) throws CardException {
		Matcher matcher = pattern.matcher(cardNumber);

		Iterator<CardType> cardTypeIterator = cardTypes.iterator();
		while(matcher.matches() && cardTypeIterator.hasNext()) {
			CardType cardType = cardTypeIterator.next();
			if (matcher.group(cardType.toString()) != null) {
				return cardType;
			}
				
		}
		throw new CardException(new CardTypeNotFoundException(cardNumber));
	}
	
	private String maskPan(String cardNumber) {
		int cardLength = cardNumber.length();
		String cardsDigitsExceptLastFour = cardNumber.substring(0, cardLength - 4);	
		String maskedPan = "*".repeat(cardsDigitsExceptLastFour.length());
		
		return maskedPan + cardNumber.substring(cardLength - 4);
	}

}
