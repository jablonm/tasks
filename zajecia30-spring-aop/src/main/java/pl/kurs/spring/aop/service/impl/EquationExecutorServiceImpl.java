package pl.kurs.spring.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kurs.spring.aop.service.CalculatorService;
import pl.kurs.spring.aop.service.EquationExectorService;

@Service
public class EquationExecutorServiceImpl implements EquationExectorService {

	@Autowired
	private CalculatorService additionCalculatorServiceImpl;
	
	@Autowired
	private CalculatorService multiplicationCalculatorServiceImpl;

	@Override
	public void execute(double a, double b, String operator) {
		System.out.println("Typ klasy dodawania: "+additionCalculatorServiceImpl.getClass());
		System.out.println("Typ klasy mnozenia: "+multiplicationCalculatorServiceImpl.getClass());
		
		if (operator.equals("+")) {
			System.out.println(additionCalculatorServiceImpl.calculate(a, b));
		} else if (operator.equals("*")) {
			System.out.println(multiplicationCalculatorServiceImpl.calculate(a, b));
		} else {
			System.out.println("Unknown operator");
		}
	}

}
