package com.farm.springdemo;

public class CricketCoach implements Coach {

	private HappyFortuneService fortuneService;
	
	// Add new private fields for email and team	
	public String emailAddress;
	public String team;
	
	// Create no-args constructor 
	CricketCoach(){
		System.out.println("CricketCoach: Inside no-args construtor");
	}
	
	// Create setter method
	public void setFortuneService(HappyFortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyPractice() {
		return "Do 2 hours bowling practice daily";
	}

	@Override
	public String getDailyFortune() {
		return "Good to go "+fortuneService.getFortune();
	}

}
