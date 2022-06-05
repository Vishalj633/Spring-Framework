package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public final class MyDemoLoggingAspect {

	// This is the class where we add all our related advices for logging
	
	// Let's start with the @Before advice
//	
//	@Pointcut("execution(* com.myapp.aopdemo.dao.*.*(..))")
//	 private void forDaoPackage() {}  	/*	Name of the point-cut declaration, could be any name	*/
//	
//	// Create point cut for getter method
//	@Pointcut("execution(* com.myapp.aopdemo.dao.*.get*(..))")
//	private void getter() {}
//	
//	// Create point cut for setter method
//	@Pointcut("execution(* com.myapp.aopdemo.dao.*.set*(..))")
//	private void setter() {}
//	
//	// Create point cut: include package ... exclude getter/setter
//	@Pointcut("forDaoPackage() && !(getter() || setter())")	
//	private void forDaoPackageNoGetterSetter() {}
//	
	
	@Before("com.myapp.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	//@Before("forDaoPackage()")	/*	Apply point cut declaration to advice	*/
	//@Before("execution(* com.myapp.aopdemo.dao.*.*(..))")
	//@Before("execution(* add*(..))")
	//@Before("execution(* add*(com.myapp.aopdemo.Account, ..))")/* .. means match any number of arguments */
	//@Before("execution(* add*(Account))") /* lets break it by not passing fully qualified class name*/
	//@Before("execution(* add*(com.myapp.aopdemo.Account))") /*Fully qualified class name as a parameter*/
	//@Before("execution(* add*())")  /*Access modifier is optional*/
	//@Before("execution(public void add*())")
	//@Before("execution(public void com.myapp.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void updateAccount())")
	public void beforeAddAnyMethodAdvice() {
		
		System.out.println("\n|=====>>> Executing @Before advice on add*()");

		
		//System.out.println("\n|=====>>> Executing @Before advice on addAccount()");
		
		//System.out.println("\n|=====>>> Executing @Before advice on updateAccount()");
	
	}
	
//	@Before("forDaoPackageNoGetterSetter()")
//	public void performApiAnalyitcs() {
//		
//		System.out.println("\n|=====>>> Performing API analytics");
//
//	}
	
//	@Before("forDaoPackageNoGetterSetter()")
//	public void logInToCloudAsync() {
//		
//		System.out.println("\n|=====>>> Logging to cloud in async manner ");
//
//	}
	
	
}
