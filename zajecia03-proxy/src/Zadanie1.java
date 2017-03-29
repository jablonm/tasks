import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Zadanie1 {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * napisz metode ktora obliczy nty wyraz ciagu fib.
		 */

		// for(int i=1; i<5000; i++){
		// System.out.println("fib("+i+")="+f2(i));
		// }
		//long start = System.currentTimeMillis();
		System.out.println(f2(100));
		//long time = System.currentTimeMillis() - start;
		//System.out.println("time: " + time + "[ms]");
		System.out.println(f2(100));

	}

	public static int f(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return f(n - 1) + f(n - 2);
		}
	}

	static Map<Integer, BigInteger> cache = new HashMap<>();

	public static BigInteger f2(int n) throws InterruptedException {
		long start = System.currentTimeMillis();
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");
		BigInteger tmp = null;

		if (cache.containsKey(n)) {
			long time = System.currentTimeMillis() - start;
			System.out.println("time: " + time + "[ms]");
			return cache.get(n);
		} else {
			for (int i = 1; i < n; ++i) {
				tmp = a;
				a = b;
				b = b.add(tmp);
				Thread.sleep(10);
			}
			cache.put(n, b);
			long time = System.currentTimeMillis() - start;
			System.out.println("time: " + time + "[ms]");
			return b;
		}
		
		
	}
}
