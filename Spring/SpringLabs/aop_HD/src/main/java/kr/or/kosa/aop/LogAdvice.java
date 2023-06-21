package kr.or.kosa.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {
	
//	@Before("target(kr.or.kosa.service.SampleService)")
	@Before("execution(* kr.or.kosa.service.SampleService*.*(..))")	
	public void logBefore() {
		System.out.println("Before : ==============================");
	}

	@After("execution(* kr.or.kosa.service.SampleService*.*(..))")
	public void logAfter() {
		System.out.println("After  : ==============================");
	}

	@AfterThrowing(pointcut = "execution(* kr.or.kosa.service.SampleService*.*(..))", throwing = "exception")
	public void logAfterThrowing(Exception exception) {
		System.out.println("After throwing : ======================");
		System.out.println("Exception: " + exception.getMessage());
	}	
	

	@Around("execution(* kr.or.kosa.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		//System.out.println("Target : " + pjp.getTarget());
		//System.out.println("Proxy : " + pjp.getThis().getClass().getName());
		System.out.println("Param : " + Arrays.toString(pjp.getArgs()));

		Object result = null;

		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			System.out.println(e);
			throw e;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("TIme : " + (endTime - startTime));

		return result;
	}
	
	
}




