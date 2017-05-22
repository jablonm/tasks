import java.math.BigInteger;

public class Oyster {

	private BigInteger debit;

	public BigInteger getDebit() {
		return debit;
	}

	public void setDebit(BigInteger debit) {
		this.debit = debit;
	}
	
	public Oyster(BigInteger debit) {
		this.debit = debit;
	}

	private void pay(BigInteger value) {
		debit = debit.subtract(value);
	}
	
	private void charge(BigInteger value) {
		this.setDebit(value);
	}

	private void calculate(Station from, Station to) {
		
	}
	
}
