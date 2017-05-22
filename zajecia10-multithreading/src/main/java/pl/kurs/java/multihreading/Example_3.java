package pl.kurs.java.multihreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Dlaczego dzia³a wolniej w w¹tkach???
//Dlaczego dzia³a wolniej w w¹tkach???
//Dlaczego dzia³a wolniej w w¹tkach???

public class Example_3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array = new int[300000000];
		ExecutorService executor = Executors.newFixedThreadPool(4);

		long start = System.currentTimeMillis();

		Fill fill1 = new Fill(0, 75000000, array);
		Fill fill2 = new Fill(75000000, 150000000, array);
		Fill fill3 = new Fill(150000000, 225000000, array);
		Fill fill4 = new Fill(225000000, 300000000, array);

		Future<int[]> array1 = executor.submit(fill1);
		Future<int[]> array2 = executor.submit(fill2);
		Future<int[]> array3 = executor.submit(fill3);
		Future<int[]> array4 = executor.submit(fill4);

		List<int[]> arrays = new ArrayList<>();
		arrays.add(array1.get());
		arrays.add(array2.get());
		arrays.add(array3.get());
		arrays.add(array4.get());
		System.out.println(System.currentTimeMillis() - start);
		executor.shutdown();
	}

	private static class Fill implements Callable<int[]> {
		private int min;
		private int max;
		private int[] array;
		private Random random;

		public Fill(int min, int max, int[] array) {
			this.min = min;
			this.max = max;
			this.array = array;
			this.random = new Random();
		}

		@Override
		public int[] call() throws Exception {
			for (int i = min; i < max; i++) {
				array[i] = (int) (random.nextInt(array.length));
			}
			return array;
		}

	}

}
