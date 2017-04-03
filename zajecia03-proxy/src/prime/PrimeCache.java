package prime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeCache implements PrimeNumbers {

	private final PrimeNumbersImpl targetObjectProxy;
	private final Map<PrimesPair, List<Integer>> cache;
	
	public PrimeCache(PrimeNumbersImpl targetObjectProxy) {
		this.targetObjectProxy = targetObjectProxy;
		this.cache = new HashMap<>();
	}

	@Override
	public List<Integer> getPrimes(int from, int to) {
		PrimesPair primesPair = new PrimesPair(from, to);
		if(!cache.containsKey(primesPair)){
			cache.put(primesPair, targetObjectProxy.getPrimes(from, to));
		}
		return cache.get(primesPair);
	}
	
}