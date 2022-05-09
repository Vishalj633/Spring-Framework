package com.farm.springdemo;

public class TrackCoach implements Coach {
	
	private HappyFortuneService fortuneService;
	
	public TrackCoach(HappyFortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyPractice() {
		return "Run hard for 5km";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it :"+ fortuneService.getFortune();
	}

}
