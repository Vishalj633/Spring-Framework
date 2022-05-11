package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		
		// Choose any injection style (1. Constructor injection 2. Setter injection 3. Field injection => in spring document mentioned => get the same functionality from these 3 injection techniques) and stay consistant with throghout the project 
		
		// Read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Get the bean from the spring container
		//Coach theCoach = context.getBean("thatGoodCoach", Coach.class);   Explicit Bean Id
		Coach theCoach = context.getBean("tennisCoach", Coach.class);   // Implicit Bean Id
		
		// Call the method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// Call the method to getDailyFortune()
		System.out.println(theCoach.getDailyFortune());
		
		// Close the context
		context.close();
	}

}
