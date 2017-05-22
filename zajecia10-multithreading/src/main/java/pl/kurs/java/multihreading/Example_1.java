package pl.kurs.java.multihreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example_1 {

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(4);

		int[] array = new int[300000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * array.length);
		}
		long start = System.currentTimeMillis();
		MaxFinder finder1 = new MaxFinder(0, 75000000, array);
		MaxFinder finder2 = new MaxFinder(75000000, 150000000, array);
		MaxFinder finder3 = new MaxFinder(150000000, 225000000, array);
		MaxFinder finder4 = new MaxFinder(225000000, 300000000, array);

		Future<Integer> result1 = executor.submit(finder1);
		Future<Integer> result2 = executor.submit(finder2);
		Future<Integer> result3 = executor.submit(finder3);
		Future<Integer> result4 = executor.submit(finder4);

		int[] results = { result1.get(), result2.get(), result3.get(), result4.get() };
		int max = results[0];
		for (int i : results) {
			if (i > max)
				max = i;
		}

		System.out.println("Czas: " + (System.currentTimeMillis() - start));
		System.out.println(max);
	}

	public static class MaxFinder implements Callable<Integer> {
		private final int start;
		private final int end;
		private final int[] array;

		public MaxFinder(int start, int end, int[] array) {
			this.start = start;
			this.end = end;
			this.array = array;
		}

		@Override
		public Integer call() throws Exception {
			int max = array[start];
			for (int i = start; i < end; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			return max;
		}

	}
}
