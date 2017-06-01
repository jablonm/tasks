
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calc
 */
@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Operator> operations;

	@Override
	public void init() throws ServletException {
		operations = new ConcurrentHashMap<>();
		operations.put("+", this::add);
		operations.put("-", this::subtract);
		operations.put("*", this::multiply);
		operations.put("/", this::divide);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			Equation equation = Equation.create(request, operations.keySet());
			out.println(equation.getD1() + " " + equation.getOperator() + " " + equation.getD2() + " = "//
					+ operations.get(equation.getOperator()).calculate(equation.getD1(), equation.getD2()));//
		} catch (IllegalArgumentException e) {
			out.println("<font color=\"red\">" + e.getMessage() + "</font>");
		}
	}

	//implementacja interfejsu Operator, metoda pasuje do sygnatury metody calculate
	public BigDecimal add(BigDecimal d1, BigDecimal d2) {
		return d1.add(d2);
	}

	public BigDecimal subtract(BigDecimal d1, BigDecimal d2) {
		return d1.subtract(d2);
	}

	public BigDecimal multiply(BigDecimal d1, BigDecimal d2) {
		return d1.multiply(d2);
	}

	public BigDecimal divide(BigDecimal d1, BigDecimal d2) {
		return d1.divide(d2, BigDecimal.ROUND_HALF_UP);
	}

}
