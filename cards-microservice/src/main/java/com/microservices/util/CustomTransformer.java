package com.microservices.util;

import com.microservices.exception.CardException;

public interface CustomTransformer<E, D> {

	public D entityToDto(E entity);
	public E dtoToEntity(D dto) throws CardException;
}
