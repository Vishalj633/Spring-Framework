package com.myapp.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.myapp.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger =
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
			
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program : AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy Fortune : "+data);
		
		myLogger.info("Done!!!");
		
		// Close the context
		context.close();
		
	}

}