package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersImpl implements PrimeNumbers{
	
	@Override
	public List<Integer> getPrimes(int from, int to) {
		List<Integer> primes = new ArrayList<>();
		for (int i = from; i <= to; i++) {
			if (checkPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	static boolean checkPrime(int prime) {
		for (int i = 2; i < prime; i++) {
			if (prime%i==0) {
				return false;
			}
		}
		return true;
	}
	
}
