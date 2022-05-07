package com.farm.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the bean from the container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Call methods on the bean
		System.out.println(theCoach.getDailyPractice());
		
		// Close the context
		context.close();

	}

}
