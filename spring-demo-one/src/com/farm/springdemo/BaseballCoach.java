package com.farm.springdemo;

public class BaseballCoach implements Coach{
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
	
	//Define a constructor for the dependency injection
	BaseballCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}
	
	
	@Override
	public String getDailyPractice() {
		return "Spend 30 minutes in batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		// Use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
	
}
