package com.app.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "Keep it Buddy!, It's your day";
	}

}
