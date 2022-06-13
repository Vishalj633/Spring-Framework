package com.myapp.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.myapp.aopdemo.Account;

@Aspect
@Component
@Order(2)
public final class MyDemoLoggingAspect {

	
	// Add a new advice for @Afterreturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.myapp.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n====> Executing @AfterReturning on method : "+method);
		
		// print out the result of the method call
		System.out.println("Result : "+result);
		
		// Let's post process the data ... let's modify the data
		
		// Convert the account names to upper-case
		convertAccountNamesToUppercase(result);
		
		System.out.println("Result : "+result);
		
		
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
		
		System.out.println("\n|=====>>> Executing @Before advice on add*()");
		
		// Display method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method signature : "+methodSig);
		
		// Display method arguments
		
		// Get args
		Object[] args = theJoinPoint.getArgs();
		
		// Loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				// Downcast and print account specific stuff
				Account theAccount = (Account)tempArg;
				
				System.out.println("Account Name : "+theAccount.getName());
				System.out.println("Account Level : "+theAccount.getLevel());
				
			}
		}
		
	}
	

	
	
}
