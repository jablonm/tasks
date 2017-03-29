import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciCacheProxy implements Fibonacci {

	private final Fibonacci targetProxyObject;
	private final Map<Integer, BigInteger> cache;

	public FibonacciCacheProxy(Fibonacci targetProxyObject) {
		this.targetProxyObject = targetProxyObject;
		this.cache = new HashMap<>();
	}

	@Override
	public BigInteger getN(int n) {
		if(!cache.containsKey(n)){
			cache.put(n, targetProxyObject.getN(n));
		}
		return cache.get(n);
	}

}
