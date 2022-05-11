package com.app.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	// Create an array of strings 
	private String[] data= {
			"Hello today is sunny day",
			"Hello today is cloudy day",
			"No fortune today"
	};
	
	// Create random number generator 
	private Random myRandom = new Random();
	
	@Override
	public String getMyFortune() {
		
		// Pick a random string from the array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
