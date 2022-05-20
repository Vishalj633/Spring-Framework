package com.app.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${my.email}")
	private String email;
	
	@Value("${my.team}")
	private String team;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 m as practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getMyFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
