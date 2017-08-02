package pl.kurs.spring.aop.printer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.printer.annotation.NotNullText;

@Aspect
@Service
public class NotNullTextAspect {

	@Before("@annotation(notNullText)")
	public void validateNullText(JoinPoint joinPoint, NotNullText notNullText) {
		for (Object o : joinPoint.getArgs()) {
			if (o == null) {
				throw new IllegalArgumentException("Nalezy wypelnic wszystkie pola"); 
			}
		}
	}
	
}
