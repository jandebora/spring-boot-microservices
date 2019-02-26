package com.microservices.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.domain.Card;
import com.microservices.dto.CardDto;
import com.microservices.dto.CardDtoCollection;
import com.microservices.exception.CardException;
import com.microservices.repository.CardRepository;
import com.microservices.util.CardTransformer;

@Service
@Transactional
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private CardTransformer cardTransformer;

	@Override
	public CardDto getCard(Long id) {
		Card card = cardRepository.getOne(id);
		
		return cardTransformer.entityToDto(card);
	}

	@Override
	public CardDtoCollection getAllCards() {
		Collection<Card> cards = cardRepository.findAll();
		
		return new CardDtoCollection(cards.stream()
				.map(card -> cardTransformer.entityToDto(card))
				.collect(Collectors.toList()));
	}

	@Override
	public CardDto addCard(CardDto cardDto) throws CardException {
		Card card = cardRepository.save(cardTransformer.dtoToEntity(cardDto));
		cardDto.setId(card.getId());
		cardDto.setCardType(card.getType());
		cardDto.setCardNumber(card.getMaskedPan());
		
		return cardDto;
	}

	@Override
	public CardDto updateCard(CardDto cardDto) throws CardException {
		Card card = cardRepository.save(cardTransformer.dtoToEntity(cardDto));
		cardDto.setCardType(card.getType());
		cardDto.setCardNumber(card.getMaskedPan());
		
		return cardDto;
	}

	@Override
	public void deleteCard(Long id) {
		cardRepository.deleteById(id);
	}

}
