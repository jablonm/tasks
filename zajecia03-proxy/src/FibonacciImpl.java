import java.math.BigInteger;

public class FibonacciImpl implements Fibonacci {

	@Override
	public BigInteger getN(int n) {
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger tmp = null;
		for (int i = 1; i < n; ++i) {
			tmp = a;
			a = b;
			b = b.add(tmp);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

}
