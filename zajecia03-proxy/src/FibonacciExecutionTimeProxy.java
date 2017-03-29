import java.math.BigInteger;

public class FibonacciExecutionTimeProxy implements Fibonacci {

	private final Fibonacci targetProxyObject;

	public FibonacciExecutionTimeProxy(Fibonacci targetProxyObject) {
		this.targetProxyObject = targetProxyObject;
	}

	@Override
	public BigInteger getN(int n) {
		long start = System.currentTimeMillis();
		BigInteger result = targetProxyObject.getN(n);
		long end = System.currentTimeMillis() - start;
		System.out.println("Execution time for fib(" + n + ") is:" + end + " [ms]");
		return result;
	}

}
