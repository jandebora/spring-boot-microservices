package com.microservices.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	Collection<Card> findByUserId(Long idUser);
}
