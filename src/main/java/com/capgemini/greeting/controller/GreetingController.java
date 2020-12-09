package com.capgemini.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.greeting.model.Greeting;
import com.capgemini.greeting.model.User;
import com.capgemini.greeting.service.IGreetingInterface;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	private IGreetingInterface greetingService;
	
	@GetMapping(value = {"", "/", "/home"})
	public Greeting greeting(@RequestParam(value="name", defaultValue= "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	@RequestMapping("/id")
	public Greeting getId(@RequestParam(value="id") long id) {
		return greetingService.getGreetingById(id);
	}
	
}
