
public class EquationExample {
	public static void main(String[] args) {
		EquationEngine engine = new EquationEngine();
		
		System.out.println(engine.solve(new Equation("2.5 + 2.5")));
		System.out.println(engine.solve(new Equation("2.5 - 2.5")));
		System.out.println(engine.solve(new Equation("2.5 * 2.5")));
		System.out.println(engine.solve(new Equation("2.5 / 2.5")));
		System.out.println(engine.solve(new Equation("2.5 ^ 2.5")));
	}
}
