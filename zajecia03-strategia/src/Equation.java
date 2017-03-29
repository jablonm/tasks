
public class Equation {
	private final String operator;
	private final double d1;
	private final double d2;

	public Equation(String source) {
		String[] args = source.split(" ");
		this.operator = args[1];
		this.d1 = Double.parseDouble(args[0]);
		this.d2 = Double.parseDouble(args[2]);
	}
	
	public String getOperator() {
		return operator;
	}

	public double getD1() {
		return d1;
	}

	public double getD2() {
		return d2;
	}

}
