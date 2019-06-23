package com.ruhul.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	
	// create pointcut declaration
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	// create pointcut for getter method
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.get*(..))")
	public void getter() {

	}

	// create pointcut for setter method
	@Pointcut("execution(* com.ruhul.aopdemo.dao.*.set*(..))")
	public void setter() {

	}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {

	}
}
