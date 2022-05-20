package com.app.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.app.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// Define bean for our sad fortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// Define bean for our swim coach and inject dependencies
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
