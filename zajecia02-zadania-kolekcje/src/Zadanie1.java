import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie1 {
	public static void main(String[] args) {
		/*
		 * Napisz metode topN ktora jako argument pobiera int n, oraz Liste
		 * integerow (interfejs List) a jako wynik zwraca topN najwiekszych
		 * elementow z tej listy np: lista [1,2,3,4,5,6] topN(3, lista) =
		 * [6,5,4]
		 * 
		 * *rzuc IllegalArgumentException w przypadku gdy z jakiegos powodu
		 * uzyskanie wyniku jest nie mozliwe.
		 */

		List<Integer> testElements = new ArrayList<Integer>();
		testElements.add(5);
		testElements.add(1);
		testElements.add(25);
		testElements.add(12);
		testElements.add(6);
		testElements.add(8);
		testElements.add(14);
		testElements.add(65);
		testElements.add(0);
		int n =2;
		System.out.println(topN(n, testElements));
		System.out.println(testElements);
		
	}
//STACK 
	public static List<Integer> topN(int n, List<Integer> elements) {
		validateTopNArguments(n, elements);
		
//		List<Integer> tmpElements = new ArrayList<>(elements); 
//		
//		List<Integer> topN = new ArrayList<Integer>();
//		tmpElements.sort((o1, o2) -> o1 - o2);
//
//		int i = 0;
//		while (i < n) {
//			topN.add(tmpElements.get(tmpElements.size() - 1 - i));
//			i++;
//		} 
		return elements.stream().sorted(Collections.reverseOrder()).limit(n).collect(Collectors.toList());
	}

	private static void validateTopNArguments(int n, List<Integer> elements) {
		if(elements==null){
			throw new IllegalArgumentException("Elements cannot be null");
		}
		if(n>elements.size()){
			throw new IllegalArgumentException("N cannot be greater then elements size");
		}
		if(n<1){
			throw new IllegalArgumentException("N should be at least 1!");
		}
	}
}
