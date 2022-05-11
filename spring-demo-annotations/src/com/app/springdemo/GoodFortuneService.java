package com.app.springdemo;
import org.springframework.stereotype.Component;

@Component
public class GoodFortuneService implements FortuneService {

	@Override
	public String getMyFortune() {
		return "Good to go";
	}

}
