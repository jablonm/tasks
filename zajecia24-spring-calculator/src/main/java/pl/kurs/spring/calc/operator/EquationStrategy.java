package pl.kurs.spring.calc.operator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquationStrategy {

	private final Map<String, Operator> operatorsMap;

	@Autowired
	public EquationStrategy(Set<Operator> operators) {
		this.operatorsMap = operators.stream().collect(Collectors.toMap(Operator::key, Function.identity()));
	}

	public BigDecimal calculate(BigDecimal d1, BigDecimal d2, String operator) {
		return operatorsMap.get(operator).calculate(d1, d2);
	}
}
