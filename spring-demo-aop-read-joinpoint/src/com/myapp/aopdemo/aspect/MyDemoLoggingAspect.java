package com.myapp.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
