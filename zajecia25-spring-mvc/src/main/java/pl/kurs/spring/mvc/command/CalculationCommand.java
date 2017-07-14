package pl.kurs.spring.mvc.command;

import java.math.BigDecimal;

public class CalculationCommand {
	private BigDecimal l1;
	private BigDecimal l2;
	private String operator;

	public BigDecimal getL1() {
		return l1;
	}

	public void setL1(BigDecimal l1) {
		this.l1 = l1;
	}

	public BigDecimal getL2() {
		return l2;
	}

	public void setL2(BigDecimal l2) {
		this.l2 = l2;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
