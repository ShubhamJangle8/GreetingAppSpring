package com.capgemini.greeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/getall")
	public List<Greeting> getAll() {
		return greetingService.getAll();
	}
	@RequestMapping("/update")
	public List<Greeting> updateGreeting(@RequestParam(value="id") long id, @RequestParam(value="name") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.updateGreeting(id, user);
	}
	@RequestMapping("/delete")
	public List<Greeting> deleteGreeting(@RequestParam(value="id") long id) {
		return greetingService.deleteGreeting(id);
	}
	@RequestMapping("/deleteall")
	public List<Greeting> deleteAllGreeting() {
		return greetingService.deleteAllGreeting();
	}
	
}
