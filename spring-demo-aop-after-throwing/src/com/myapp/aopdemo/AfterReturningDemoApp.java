package com.myapp.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.aopdemo.dao.AccountDAO;
import com.myapp.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// Call the methods to find the accounts
		List<Account>theAccounts=theAccountDAO.findAccounts(false);
		
		// Display the Accounts
		System.out.println("\n Main Program : AfterReturningDemoApp");
		System.out.println("------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		// Close the context
		context.close();
		
	}

}

