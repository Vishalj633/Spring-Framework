package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public final class MyDemoLoggingAspect {

	// This is the class where we add all our related advices for logging
	
	// Let's start with the @Before advice
	
	@Before("execution(* com.myapp.aopdemo.dao.*.*(..))")
	//@Before("execution(* add*(..))")
	//@Before("execution(* add*(com.myapp.aopdemo.Account, ..))")/* .. means match any number of arguments */
	//@Before("execution(* add*(Account))") /* lets break it by not passing fully qualified class name*/
	//@Before("execution(* add*(com.myapp.aopdemo.Account))") /*Fully qualified class name as a parameter*/
	//@Before("execution(* add*())")  /*Access modifier is optional*/
	//@Before("execution(public void add*())")
	//@Before("execution(public void com.myapp.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void updateAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n|=====>>> Executing @Before advice on add*()");

		
		//System.out.println("\n|=====>>> Executing @Before advice on addAccount()");
		
		//System.out.println("\n|=====>>> Executing @Before advice on updateAccount()");
	
	}
	
}
