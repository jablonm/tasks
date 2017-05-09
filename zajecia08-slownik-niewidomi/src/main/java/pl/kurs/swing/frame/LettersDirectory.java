package pl.kurs.swing.frame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LettersDirectory {

	private final Map<Letter, Character> letters = new HashMap<>();

	public void generateBlindDirectory() {
		letters.clear();
		this.addLetter(new Letter('a', "s"));
		this.addLetter(new Letter('b', "ds"));
		this.addLetter(new Letter('c', "js"));
		this.addLetter(new Letter('d', "jks"));
		this.addLetter(new Letter('e', "ks"));
		this.addLetter(new Letter('f', "djs"));
		this.addLetter(new Letter('g', "djks"));
		this.addLetter(new Letter('h', "dks"));
		this.addLetter(new Letter('i', "dj"));
		this.addLetter(new Letter('j', "djk"));
		this.addLetter(new Letter('k', "fs"));
		this.addLetter(new Letter('l', "dfs"));
		this.addLetter(new Letter('m', "jfs"));
		this.addLetter(new Letter('n', "fjks"));
		this.addLetter(new Letter('o', "fks"));
		this.addLetter(new Letter('p', "dfjs"));
		this.addLetter(new Letter('q', "dfjks"));
		this.addLetter(new Letter('r', "dfks"));
		this.addLetter(new Letter('s', "dfj"));
		this.addLetter(new Letter('t', "dfjk"));
		this.addLetter(new Letter('u', "fls"));
		this.addLetter(new Letter('v', "dfls"));
		this.addLetter(new Letter('w', "djkl"));
		this.addLetter(new Letter('x', "fjls"));
		this.addLetter(new Letter('y', "fjkls"));
		this.addLetter(new Letter('z', "fkls"));
		//FJ -> spacja
		//FD -> ENTER
		//FS -> backspace
	}

	public Optional<Character> findLetter(Set<Character> sequence) {
		Letter searchedLetter = new Letter(toString(sequence));
		return Optional.ofNullable(Optional.of(letters.get(searchedLetter))).orElse(Optional.empty());
//		if (letters.containsKey(searchedLetter)) {
//			System.out.println("slownik: " + letters.get(searchedLetter));
//			return Optional.of(letters.get(searchedLetter));
//		} else {
//			return Optional.empty();
//		}
	}

	private String toString(Set<Character> sequence) {
		String result = "";
		for (Character character : sequence) {
			result += character.toString();
		}
		return result;
	}

	private void addLetter(Letter letter) {
		letters.put(letter, letter.getLetter());
	}

}
