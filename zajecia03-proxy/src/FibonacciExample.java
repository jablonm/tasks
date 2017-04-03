import java.util.ArrayList;
import java.util.List;

public class FibonacciExample {
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		List<String> imiona = null;
		@SuppressWarnings("unused")
		ArrayList<String> lista  =null;
		
		Fibonacci fib =new FibonacciCacheProxy(new FibonacciImpl());
		//-----------------------------
		System.out.println(fib.getN(10));
		System.out.println(fib.getN(10));
	}
}
