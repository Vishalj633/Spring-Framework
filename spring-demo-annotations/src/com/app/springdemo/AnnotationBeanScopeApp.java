package com.app.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

	public static void main(String[] args) {
		// Load spring config file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach theAlphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// Check whether they are same
		boolean result = (theCoach == theAlphaCoach);
		
		// Print out results 
		System.out.println("\n Pointing to the same object : "+result);
		
		System.out.println("\n Memory location for theCoach: "+theCoach);

		System.out.println("\n Memory location for theAlphaCoach: "+theAlphaCoach);

		// Close the context
		context.close();
	}

}
