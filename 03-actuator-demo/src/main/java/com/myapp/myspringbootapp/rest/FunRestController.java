package com.myapp.myspringbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Expose "/" that return "Hello-world"
	@GetMapping("/")
	public String sayHello() {
		return "Hello world this is Vishal, Time on server is : "+LocalDateTime.now();
	}
	
	// Expose new endpoint for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 5km";
	}
	
	// Expose new endpoint for fortune
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Best luck for your journey";
	}
}
