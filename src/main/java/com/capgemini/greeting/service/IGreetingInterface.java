package com.capgemini.greeting.service;

import java.util.List;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;

public interface IGreetingInterface {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAll();
	List<Greeting> updateGreeting(long id, User user);
	List<Greeting> deleteGreeting(long id);
	List<Greeting> deleteAllGreeting();
}
