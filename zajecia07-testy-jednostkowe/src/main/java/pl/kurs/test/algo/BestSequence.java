package pl.kurs.test.algo;

public class BestSequence {

	public int[] bestSequence(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array should not be null");
		}
		int actualBeginning = 0;
		int actualEnd = 0;
		int maxBeginning = 0;
		int maxEnd = 0;

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				actualEnd = i;
				if ((actualEnd - actualBeginning) >= (maxEnd - maxBeginning)) {
					maxBeginning = actualBeginning;
					maxEnd = actualEnd;
					actualBeginning = i + 1;
				} else {
					actualBeginning = i + 1;
				}
			}
		}

		int indx = 0;
		int[] bestSequence = new int[maxEnd + 1 - maxBeginning];
		for (int j = maxBeginning; j <= maxEnd; j++) {
			bestSequence[indx] = array[j];
			indx++;
		}
		return bestSequence;
	}

	//	public static void main(String[] args) {
	//		int[] test = {1,2,3,1,2,3,4,1,2,3,4,5,6,7};
	//		int[] wynik = bestSequence(test);
	//		 for (int i : wynik) {
	//		 System.out.print(i + " ");
	//		 }
	//}

}
