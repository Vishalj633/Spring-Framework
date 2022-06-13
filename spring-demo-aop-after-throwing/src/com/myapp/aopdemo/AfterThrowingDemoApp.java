package com.myapp.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// Call the methods to find the accounts
		List<Account>theAccounts=null;
		
		try {
			// Add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts=theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exp) {
			System.out.println("\n Main program caught excpeption: "+exp);
		}
		
		// Display the Accounts
		System.out.println("\n Main Program : AfterThrowingDemoApp");
		System.out.println("------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		// Close the context
		context.close();
		
	}

}