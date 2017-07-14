package pl.kurs.spring.calc.operator.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pl.kurs.spring.calc.operator.Operator;

@Service
public class PowerOperatorImpl implements Operator {

	@Override
	public BigDecimal calculate(BigDecimal d1, BigDecimal d2) {
		return d1.pow(d2.intValue());
	}

	@Override
	public String key() {
		return "^";
	}

}
