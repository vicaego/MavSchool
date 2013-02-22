package com.school.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class InjectMe {

	@Before("execution(* com.school.students.StudentsDAO.update(..))")
	public void injectBefore(JoinPoint joinPoint) {
		System.out.println("INJECT Before! Returned: " + joinPoint);
	}
	@After("execution(* com.school.students.StudentsDAO.update(..))")
	public void injectAfter(JoinPoint joinPoint) {
		System.out.println("INJECT AFTER! Returned: " + joinPoint);
	}

	
}
