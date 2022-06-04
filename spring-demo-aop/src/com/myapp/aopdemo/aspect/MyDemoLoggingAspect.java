package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public final class MyDemoLoggingAspect {

	// This is the class where we add all our related advices for logging
	
	// Let's start with the @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n|=====>>> Executing @Before advice on addAccount()");
	}
	
}
