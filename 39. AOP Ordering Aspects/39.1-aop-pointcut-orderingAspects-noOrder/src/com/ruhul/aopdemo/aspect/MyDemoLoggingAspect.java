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

	// create pointcut for getter method
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.get*(..))")
	private void getter() {

	}

	// create pointcut for setter method
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.set*(..))")
	private void setter() {

	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {

	}

	// apply pointcut declaration to advice
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Performing API analytics");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n====>>> Logging to Cloud in async fashion");
	}
}
