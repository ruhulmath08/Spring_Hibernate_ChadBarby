package com.odduu.ruhul.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup poincut declaration for controller
	@Pointcut("execution(* com.odduu.ruhul.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	// setup poincut declaration for dao
	@Pointcut("execution(* com.odduu.ruhul.dao.*.*(..))")
	private void forDaoPackage() {
			
	}
	
	// setup poincut declaration for service
	@Pointcut("execution(* com.odduu.ruhul.service.*.*(..))")
	private void forServicePackage() {
				
	}
	
	// combine pointcut
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {
		
	}
	
	// setup @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
	}
	// add @AfterReturning advice
}
