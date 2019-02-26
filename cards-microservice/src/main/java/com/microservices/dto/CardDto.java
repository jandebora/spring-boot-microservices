package com.microservices.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.microservices.domain.CardType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class CardDto {

	private Long id;
	private @NotNull Long userId;
	private @NotEmpty String cardNumber;
	private CardType cardType;
}
