package pl.kurs.spring.aop.service.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.service.CalculatorService;

@Service
public class AdditionCalculatorServiceImpl implements CalculatorService {

	@Override
	public double calculate(double a, double b) {
		System.out.println("Uruchamiam calc w addition");
		return a + b;
	}

}
