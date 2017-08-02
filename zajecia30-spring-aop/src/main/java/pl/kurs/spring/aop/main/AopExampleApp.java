package pl.kurs.spring.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kurs.spring.aop.config.AopExampleApplicationConfiguration;
import pl.kurs.spring.aop.service.EquationExectorService;

public class AopExampleApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopExampleApplicationConfiguration.class);
		context.getBean(EquationExectorService.class).execute(10, -20, "*");
	}
}
