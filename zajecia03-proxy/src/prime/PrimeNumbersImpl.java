package prime;

import java.util.List;

public class PrimeNumbersImpl implements PrimeNumbers{
	
	@Override
	public List<Integer> getPrimes(int from, int to) {
		
		for (int i = from; i <= to; i++) {
			for (int j = 2; j <= i; j++) {
				if (i%j==0) {
					System.out.println(i);
				}
			}
		}
		return null;
	}

	
}
