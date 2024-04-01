package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class controllerAspect {
	@Pointcut("execution(* com.example.controller.RestApiController.*(..)) ")
	private void anyController() {
	}

	@Before("anyController()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method -> " + joinPoint.getSignature());
	}

	@After("anyController()")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method -> " + joinPoint.getSignature());
	}

	@AfterThrowing("anyController()")
	public void afterThrowAdvice(JoinPoint joinPoint) {
		System.out.println("After throw method -> " + joinPoint.getSignature());
	}

	@AfterReturning("anyController()")
	public void afterReturnAdvice(JoinPoint joinPoint) {
		System.out.println("After return method -> " + joinPoint.getSignature());
	}

	@Around("anyController()")
	public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Around method start -> " + jp.getSignature());
		try {
			return jp.proceed();
		} finally {
			System.out.println("Around method end -> " + jp.getSignature());
		}
	}

	//@Around(value = "anyController()")
	public void aroundAdvice2(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("The method aroundAdvice() before invokation of the method " + jp.getSignature()
				.getName() + " method");
		try {
			jp.proceed();
		} finally {
		}
		System.out.println("The method aroundAdvice() after invokation of the method " + jp.getSignature()
				.getName() + " method");
	}

	//@Around("anyController()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			long executionTime = System.currentTimeMillis() - start;
			System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
			return result;
		} catch (Throwable throwable) {
			long executionTime = System.currentTimeMillis() - start;
			System.out.println(joinPoint.getSignature() + " failed in " + executionTime + "ms");
			throw throwable;
		}
	}
}
