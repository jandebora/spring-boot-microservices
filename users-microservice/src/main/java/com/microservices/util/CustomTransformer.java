package com.microservices.util;


public interface CustomTransformer<E, D> {

	public D entityToDto(E entity);
	public E dtoToEntity(D dto);
}
