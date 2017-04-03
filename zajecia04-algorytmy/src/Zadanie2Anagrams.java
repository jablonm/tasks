import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Zadanie2Anagrams {
	public static void main(String[] args) {
		try (BufferedReader in = new BufferedReader(new FileReader("anagram.txt"))) {
			String line = null;
			while ((line = in.readLine()) != null) {
//				System.out.println(line);
				String[] words = line.split(" ");

				String keyWord = "";
				char[] letters = words[0].toCharArray();
				Arrays.sort(letters);
				keyWord = new String(letters);

				Boolean anagram = true;
				for (String string : words) {
					char[] wordLetters = string.toCharArray();
					Arrays.sort(wordLetters);
					String cmpWord = new String(wordLetters);
					
					if (!cmpWord.equals(keyWord)) {
						anagram = false;
					}
				}
				if (anagram) {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
