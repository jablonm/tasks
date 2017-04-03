package prime;

/*
 * Stworz Interfejs PrimeNumbers ktory posiada metode List<Integer> getPrimes(int from, int to)
 * natywna implementacja (algorytm ktory to zrobi) +
 * dodaj w postaci proxy mozliwosc cachoowania wynikow
 * dodaj w postaci proxy mozliwosc liczenia czasu wykoannia polecenia
 * dodaj w postaci proxy mozliwosc zapisu liczb do pliku*
 * format w pliku: Prime numbers from quote(form, to) are: [p1, p2, p3....pn]
 */

public class PrimeExample {
	public static void main(String[] args) {
		
		PrimeNumbers test = new PrimeCache(new PrimeNumbersImpl());
		
		System.out.println(test.getPrimes(2, 140));
		System.out.println(test.getPrimes(10, 20));
		System.out.println(test.getPrimes(19, 100));
		System.out.println(test.getPrimes(2, 140));
	}
}
