package com.myapp.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.myapp.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.myapp.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// Print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toString();
		myLogger.info("*** Executing @Around on method : "+method);
		
		// Get begin time stamp
		long begin = System.currentTimeMillis();
		
		// Now , let's execute the given method
		Object result = theProceedingJoinPoint.proceed();
		
		// Get the ending time stamp
		long end = System.currentTimeMillis();
		
		// Compute and display the duration
		long duration = end - begin;
		
		myLogger.info("*** Duration : "+duration/1000.0+" seconds");
		
		return result;
	}
	
	
	@After("execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toString();
		myLogger.info("\n===> Executing @After (finally) on method: "+method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExp")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExp) {
		
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toString();
		myLogger.info("\n===> Executing @AfterThrowing on method: "+method);
		
		// Log the exception
		myLogger.info("\n===> The exception is : "+theExp);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("\n====> Executing @AfterReturning on method : "+method);
		
		// print out the result of the method call
		myLogger.info("Result : "+result);
		
		// Let's post process the data ... let's modify the data
		
		// Convert the account names to upper-case
		convertAccountNamesToUppercase(result);
		
		myLogger.info("Result : "+result);
		
		
	}
	
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		
		// Loop through the accounts
		
		for(Account tempAccount : result ) {
			
			// Get upper-case version of name
			String theUppercaseName = tempAccount.getName().toUpperCase();
			
			// Update the name on the account
			tempAccount.setName(theUppercaseName);
		}
	}


	@Before("com.myapp.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAnyMethodAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n|=====>>> Executing @Before advice on add*()");
		
		// Display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method signature : "+methodSig);
		
		// Display method arguments
		
		// Get args
		Object[] args = theJoinPoint.getArgs();
		
		// Loop through args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				// Downcast and print account specific stuff
				Account theAccount = (Account)tempArg;
				
				myLogger.info("Account Name : "+theAccount.getName());
				myLogger.info("Account Level : "+theAccount.getLevel());
				
			}
		}
		
	}
	

	
	
}
