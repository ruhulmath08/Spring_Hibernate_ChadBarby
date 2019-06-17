package com.ruhul.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// create pointcut declaration
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

	// apply pointcut declaration to advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on method");
	}
}
