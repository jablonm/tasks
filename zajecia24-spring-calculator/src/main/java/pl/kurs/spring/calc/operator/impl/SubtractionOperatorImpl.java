package pl.kurs.spring.calc.operator.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.kurs.spring.calc.operator.Operator;

@Service
public class SubtractionOperatorImpl implements Operator {

	@Override
	public BigDecimal calculate(BigDecimal d1, BigDecimal d2) {
		return d1.subtract(d2);
	}

	@Override
	public String key() {
		return "-";
	}

}
