import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EquationEngine {
	private Map<String, Operator> operators;

	public EquationEngine(Map<String, Operator> operators) {
		this.operators = operators;
	}
	
	public EquationEngine() {
		this.operators = new HashMap<>();
		this.operators.put("+", (a,b)-> a+b);
		this.operators.put("-", (a,b)-> a-b);
		this.operators.put("*", (a,b)-> a*b);
		this.operators.put("/", (a,b)-> a/b);
		this.operators.put("^", new PowerOperatorImpl());
	}
	
	public double solve(Equation equation){
		return Optional.ofNullable(operators.get(equation.getOperator()))//
				.orElseThrow(()-> new IllegalStateException("Unknown operator: "+equation.getOperator()))//
				.calculate(equation.getD1(), equation.getD2());//
	}
	
	
}
