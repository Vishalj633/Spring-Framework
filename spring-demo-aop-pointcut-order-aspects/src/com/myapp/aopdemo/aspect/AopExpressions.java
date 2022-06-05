package com.myapp.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	
	@Pointcut("execution(* com.myapp.aopdemo.dao.*.*(..))")
	 public void forDaoPackage() {}  	/*	Name of the point-cut declaration, could be any name	*/
	
	// Create point cut for getter method
	@Pointcut("execution(* com.myapp.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// Create point cut for setter method
	@Pointcut("execution(* com.myapp.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// Create point cut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")	
	public void forDaoPackageNoGetterSetter() {}
	
}
