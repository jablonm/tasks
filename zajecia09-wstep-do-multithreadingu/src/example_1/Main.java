package example_1;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		//stworz 3 watki, kazdy wpisuje po jednej literce co jakis interwal czasowy

		Wypisywacz w1 = new Wypisywacz('a', 1);
		Wypisywacz w2 = new Wypisywacz('b', 2);
		Wypisywacz w3 = new Wypisywacz('c', 3);
		
		w1.start();
		w2.start();
		w3.start();
	}

	//klasa dziedziczy Thread
	//implementuje interfejs Runnable
	public static class Wypisywacz extends Thread {
		private final char znak;
		private final int interwalWSekundach;
		public Wypisywacz(char znak, int interwalWSekundach) {
			this.znak = znak;
			this.interwalWSekundach = interwalWSekundach;
		}
		
		//nalezy napisac cialo watku, czyli nadpisac metode run 
		@Override
		public void run() {
			while(true){
				System.out.println(znak);
				try {
					TimeUnit.SECONDS.sleep(interwalWSekundach);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		

	}

}
