import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

public class Equation {
	private final BigDecimal d1;
	private final BigDecimal d2;
	private final String operator;

	public Equation(BigDecimal d1, BigDecimal d2, String operator) {
		this.d1 = d1;
		this.d2 = d2;
		this.operator = operator;
	}

	public BigDecimal getD1() {
		return d1;
	}

	public BigDecimal getD2() {
		return d2;
	}

	public String getOperator() {
		return operator;
	}

	public static Equation create(HttpServletRequest request, Collection<String> availableOperators) {
		BigDecimal d1 = getDecimal("n1", request);
		BigDecimal d2 = getDecimal("n2", request);
		String operator = request.getParameter("operator");
		if (!availableOperators.contains(Optional.ofNullable(operator).orElse(""))) {
			throw new IllegalArgumentException("Invalid operaor: " + operator);
		}
		return new Equation(d1, d2, operator);

	}

	private static BigDecimal getDecimal(String name, HttpServletRequest request) {
		try {
			return new BigDecimal(request.getParameter(name));
		} catch (Exception e) {
			throw new IllegalArgumentException(name + " is not a number!");
		}
	}

}
