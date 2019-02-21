package com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.domain.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
