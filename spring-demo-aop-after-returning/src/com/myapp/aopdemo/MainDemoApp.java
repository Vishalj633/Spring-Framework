package com.myapp.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myapp.aopdemo.dao.AccountDAO;
import com.myapp.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		// Get the membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// Call business method
		Account myAccount = new Account();
		myAccount.setName("Vishal");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount, true); /* will only match to this */
		//theAccountDAO.addAccount();
		
		// Call the membership business method
		//theMembershipDAO.addAccount();
		theMembershipDAO.addUpdate();
		
		// Call new method
		theAccountDAO.doWork();
		theMembershipDAO.goToSleep();
		
		//	Call to the account dao getter/setter methods
		theAccountDAO.setName("Vishal");
		theAccountDAO.setServiceCode("Gold");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// Do it again
		//System.out.println("\n Lets call it again!\n");
		
		// Call the business method again
		//theAccountDAO.addAccount();

		// Close the context
		context.close();
		
	}

}
