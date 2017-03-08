package tasks01;
import java.util.Arrays;

public class Task1Anagram {
	public static void main(String[] args) {
		// napisz metode isAnagram ktora pobiera dwa stringi jako argumenty i
		// jako wynik zwraca informacje o tym czy te stringi
		// sa dla siebie anagramami np: java aavj
		System.out.println(isAnagram("java", "aavj"));

	}
	
	//static moze byc w trzech miejscach:
	//1) przy polach klasy
	//jesli pole klasy jest statyczne to znaczy ze jest jedna jego wartosc dla wszystkich instancji danej klasy
	//class Osoba { static String firma = "Java Solutions"; }
	// Osoba o1..., Osoba o2... Osoba o3 ..
	// o1.firma, o2.firma, o3.firma (atryut klasowy ) Osoba.firma
	//2) przy metodach
	//nie jest potrzebna instancja klasy aby uruchomic metode:
	//Task1Anagram t1 = new Task1Anagram();
	//t1.isAnagram(...)
	//Task1Anagram.isAnagram()
	//3) przy klasach*

	public static boolean isAnagram(String s1, String s2) {
		// sortujesz znaki w s1
		// sortujesz znaki w s2
		// budujesz nowy napis z posortowanych znakow z s1' s2'
		// sprawdzasz czy sa takie same
		return sortChars(s1).equals(sortChars(s2));
	}

	public static String sortChars(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
