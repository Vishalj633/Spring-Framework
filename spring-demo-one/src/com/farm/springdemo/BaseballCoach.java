package com.farm.springdemo;

public class BaseballCoach implements Coach{
	
	@Override
	public String getDailyPractice() {
		return "Spend 30 minutes in batting practice";
	}
	
}
