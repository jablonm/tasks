
//1) Dana jest tablica integerow o dowolnej dlugosci
//napisz algorytm ktory znajdzie najdluzszy ciag kolejnych elementow rosnacych w tablicy
//tzn: [1,2,300,1,2,3,4,1,2] najdluzszym ciagiem rosnacym bedzie [1,2,3,4] metoda ma zwracac ciag w postaci tablicy.
// 
//2) dany masz załącznik anagram.txt
//Należy wczytać dane z pliku i zostawić tylko te linie w których wyrazy są anagramami pierwszego wyrazu w linii. (anagram to wyraz złożony z tych samych liter lecz w szyku przestawnym)

public class Zadanie1BestSequence {

	// obliczeniowa O(N)
	// pamieciowa O(1)

	public static int[] bestSequence(int[] array) {

		int actualBeginning = 0;
		int actualEnd = 0;
		int maxBeginning = 0;
		int maxEnd = 0;

		for (int i = 0; i < array.length - 1; i++) {
			System.out.println(array[i] + ">" + array[i + 1]);
			if (array[i] > array[i + 1]) {
				actualEnd = i;
				System.out.println("beg " + actualBeginning + " end " + actualEnd);
				if ((actualEnd - actualBeginning) >= (maxEnd - maxBeginning)) {
					maxBeginning = actualBeginning;
					maxEnd = actualEnd;
					actualBeginning = i + 1;
				} else {
					actualBeginning = i + 1;
				}
			}
		}
		
		// Warunek w pętli powyżej nie wykona się dla ostatniego ciągu ponieważ pętla dojdzie do końca tablicy!
		// Należy sprawdzić czy ostatni ciąg w tablicy jest dłuższy od tego który wyszedł najdłuższy z pętli.
		if ((array.length - actualEnd + 1) > (maxEnd - maxBeginning + 1)) {
			maxBeginning = actualEnd + 1;
			maxEnd = array.length - 1;
		}
		
		int indx = 0;
		int[] bestSequence = new int[maxEnd + 1 - maxBeginning];
		for (int j = maxBeginning; j <= maxEnd; j++) {
			bestSequence[indx] = array[j];
			indx++;
		}
		return bestSequence;
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 300, 1, 2, 3, 4, 1, 2, 0, 4, 5, 1, 7, 8, 1, 2, 3};
		int[] wynik = bestSequence(test);
		 for (int i : wynik) {
		 System.out.print(i + " ");
		 }
	}
}
