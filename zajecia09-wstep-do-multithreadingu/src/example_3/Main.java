package example_3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		BlockingQueue<String> kolejka = new LinkedBlockingQueue<>();

		Producent producent = new Producent(new String[] { "ala", "ma", "kota", "java" }, kolejka);
		producent.start();

		Konsument konsument = new Konsument(kolejka);
		konsument.start();

	}

	private static class Producent extends Thread {
		private final String[] words;
		private final BlockingQueue<String> kolejka;

		public Producent(String[] words, BlockingQueue<String> kolejka) {
			this.words = words;
			this.kolejka = kolejka;
		}

		@Override
		public void run() {
			for (String s : words) {
				try {
					TimeUnit.SECONDS.sleep(1);
					kolejka.put(s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			try {
				kolejka.put("===finish====");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class Konsument extends Thread {
		private final BlockingQueue<String> kolejka;

		public Konsument(BlockingQueue<String> kolejka) {
			super();
			this.kolejka = kolejka;
		}

		@Override
		public void run() {
			while (true) {
				try {

					String wyraz = kolejka.take();
					if ("===finish====".equals(wyraz)) {
						break;
					} else {
						System.out.println(wyraz);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
