package com.myapp.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean(AccountDAO.class);
		
		// Call business method
		theAccountDAO.addAccount();
		
		// Do it again
		System.out.println("\n Lets call it again!\n");
		
		// Call the business method again
		theAccountDAO.addAccount();

		// Close the context
		context.close();
		
	}

}
