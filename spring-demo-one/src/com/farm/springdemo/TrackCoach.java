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
	
	// Add an init method
	public void doMyStartupWork () {
		System.out.println("TrackCoach: inside the method doMyStartupWork");
	}
	
	// Add a destroy method
	public void doMyCleanupWork () {
		System.out.println("TrackCoach: inside the method doMyCleanupWork");
	}

}
