package com.ruhul.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	// add a new advice for @AfterThrowing
	@AfterThrowing(pointcut = "execution(* com.ruhul.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExe")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {
		
		// print out which method we are advising on
		String methodString = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======> Executing @AfterThrowing on method: " + methodString);
		
		// log the exception
		System.out.println("\n======> The exception is: " + theExe);
	}

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.ruhul.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);

		// print out the result of the method call
		System.out.println("\n======>>> result is: " + result);

		// let's post-process the data ... let's modify it :-)
		// convert the account name to uppercas
		convertAccountNamesToUpperCase(result);
		System.out.println("\n=====>>> Uppercase result is: " + result);

	}

	// apply pointcut declaration to advice
	@Before("com.ruhul.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSignature);

		// display the method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
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
