package com.odduu.ruhul.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* com.odduu.ruhul.controller.*.*(..))")
	private void forControllerPackage() {

	}

	// do the same for service and dao
	@Pointcut("execution(* com.odduu.ruhul.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.odduu.ruhul.dao.*.*(..))")
	private void forDaoPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {

	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>>> in @Before: calling method: " + theMethod);

		// display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop through and display arguments
		for (Object theArg : args) {
			myLogger.info("======>>> Arguments: " + theArg);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>>> in @AfterReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("======>>> Result: " + theResult);
		
	}
}
