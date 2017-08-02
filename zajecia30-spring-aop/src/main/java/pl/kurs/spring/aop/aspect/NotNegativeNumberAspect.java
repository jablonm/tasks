package pl.kurs.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.NotNegativeNumbers;

@Aspect
@Service
public class NotNegativeNumberAspect {

	
	@Before("@annotation(notNegativeNumbers)")
	public void validateNegatives(JoinPoint joinPoint, NotNegativeNumbers notNegativeNumbers){
		for(Object o: joinPoint.getArgs()){
			Double arg = (Double) o;
			if(arg < 0){
				throw new IllegalArgumentException("Wykryto ujemny argument");
			}
		}
	}
}
