package com.app.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "Today is sad day";
	}



}
