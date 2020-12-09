package com.capgemini.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.greeting.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long>{

}
