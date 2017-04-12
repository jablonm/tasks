package pl.kurs.test.algo;
//s1 = "abc" s2="def"

// c = abcdef //zero czesci wspolnych i ani jedno ani drugie nie zawiera sie w sobie

// s1 = "abc" s2="bcd"
// c = "abcd" // koncowka s1 stanowi poczatek s2

// s1 = "abc" s2="b"
// c = "abc" // jedno zawiera sie w drugim

// s1 = "abc" s2="dab"
// c = "dabc" //poczatek s1 stanowi koniec s2

public class ShortestString {
	public String findShortest(String s1, String s2) {

		// if (!s1.contains(s2) || !s2.contains(s1)) {
		// return s1 + s2;
		// }

		for (int i = 1; i < s1.length(); i++) {
			String beg = s1.substring(0, i);
			if (s2.startsWith(beg)) {
				return s1 + s2.substring(i + 1, s2.length());
			}
		}
		
		for (int i = 1; i < s1.length(); i++) {
			String beg = s1.substring(i, s1.length());
			if (s2.startsWith(beg)) {
				return s1 + s2.substring(i + 1, s2.length());
			}
		}
		
		if (s1.contains(s2)) {
			return s1;
		} else if (s2.contains(s1)) {
			return s2;
		}

		for (int i = 1; i < s1.length(); i++) {
			String beg = s1.substring(0, i);
			if (s2.endsWith(beg)) {
				return s2 + s1.substring(i, s1.length());
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		ShortestString test = new ShortestString();
		System.out.println(test.findShortest("abxxsc123", "dabxxs"));
//		System.out.println(test.findShortest("c", "abc"));
//		System.out.println(test.findShortest("abc", "bce"));
//		System.out.println(test.findShortest("abcdef", "abhfe"));
	}
}
