package pl.kurs.spring.calc.main;

import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.kurs.spring.calc.config.CalculatorApplicationConfiguration;
import pl.kurs.spring.calc.operator.EquationStrategy;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalculatorApplicationConfiguration.class);

		EquationStrategy strategy = context.getBean(EquationStrategy.class);

		System.out.println(strategy.calculate(BigDecimal.TEN, BigDecimal.TEN, "^"));

		context.close();
	}
}
