package com.ruhul.aopdemo.aspect;

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

import com.ruhul.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// add a new advice for @Around
	@Around("execution(* com.ruhul.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @Around on method: " + method);

		// get being timestamp
		long being = System.currentTimeMillis();

		// now, lets execute the method
		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - being;
		myLogger.info("\n======> Duration: " + duration / 1000.0 + " seconds");

		return result;
	}

	// add a new advice for @AfterFilally
	@After("execution(* com.ruhul.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @After (Finally) on method: " + method);
	}

	// add a new advice for @AfterThrowing
	@AfterThrowing(pointcut = "execution(* com.ruhul.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {

		// print out which method we are advising on
		String methodString = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======> Executing @AfterThrowing on method: " + methodString);

		// log the exception
		myLogger.info("\n======> The exception is: " + theExe);
	}

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.ruhul.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterReturning on method: " + method);

		// print out the result of the method call
		myLogger.info("\n======>>> result is: " + result);

		// let's post-process the data ... let's modify it :-)
		// convert the account name to uppercas
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n=====>>> Uppercase result is: " + result);

	}

	// apply pointcut declaration to advice
	@Before("com.ruhul.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSignature);

		// display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());

			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}
		}

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts
		for (Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}
}
