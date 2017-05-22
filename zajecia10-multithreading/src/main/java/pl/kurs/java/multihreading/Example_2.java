package pl.kurs.java.multihreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example_2 {
	/*
	 * wygeneruj tab: 300 mln elementow
	 * i policz sume jej elementow rownolegle
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array = new int[300000000];

		ExecutorService executor = Executors.newFixedThreadPool(4);

		long start = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * array.length);
		}
		System.out.println(System.currentTimeMillis() - start);

		Sum sumPart1 = new Sum(0, 75000000, array);
		Sum sumPart2 = new Sum(75000000, 150000000, array);
		Sum sumPart3 = new Sum(150000000, 225000000, array);
		Sum sumPart4 = new Sum(225000000, 300000000, array);

		Future<Long> result1 = executor.submit(sumPart1);
		Future<Long> result2 = executor.submit(sumPart2);
		Future<Long> result3 = executor.submit(sumPart3);
		Future<Long> result4 = executor.submit(sumPart4);

		long[] results = { result1.get(), result2.get(), result3.get(), result4.get() };

		long result = 0;
		for (long l : results) {
			result += l;
		}
		System.out.println(result);
		executor.shutdown();
	}

	private static class Sum implements Callable<Long> {
		private int min;
		private int max;
		private int[] array;

		public Sum(int min, int max, int[] array) {
			this.min = min;
			this.max = max;
			this.array = array;
		}

		@Override
		public Long call() throws Exception {
			long result = 0;
			for (int i = min; i < max; i++) {
				result += array[i];
			}
			return result;
		}
	}

}
