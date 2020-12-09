package com.capgemini.greeting.service;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;

public interface IGreetingInterface {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
}
