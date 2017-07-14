package pl.kurs.spring.calc.operator;

import java.math.BigDecimal;

public interface Operator {
	BigDecimal calculate(BigDecimal d1, BigDecimal d2);

	String key();
}
