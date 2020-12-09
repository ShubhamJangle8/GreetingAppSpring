package com.capgemini.greeting.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;
import com.capgemini.greeting.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingInterface{
	private static String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private GreetingRepository greetingRepository;
	@Override
	public Greeting addGreeting(User user) {
		String message = String.format(template, (user.toString().isEmpty())?"Hello World" : user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
	}
	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}
}
