package pl.kurs.spring.aop.service.impl;

import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.annotation.NotNegativeNumbers;
import pl.kurs.spring.aop.service.CalculatorService;

@Service
public class MultiplicationCalculatorServiceImpl implements CalculatorService {

	@Override
	@NotNegativeNumbers
	public double calculate(double a, double b) {
		return a * b;
	}

}
