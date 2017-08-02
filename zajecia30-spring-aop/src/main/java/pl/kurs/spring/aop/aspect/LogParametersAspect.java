package pl.kurs.spring.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogParametersAspect {

	//advice(pointcut)
	//advice: kiedy uruchmic kod, pointcut = gdzie
	
	
	@Before("execution(* pl.kurs.spring.aop.service.impl.*.calculate(..))")
	public void logParameters(JoinPoint joinPoint) {
		System.out.println("Uruchomiono: "+joinPoint.getTarget().getClass());
		System.out.println("Argumenty: "+Arrays.toString(joinPoint.getArgs()));
	}
}
