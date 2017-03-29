
public class Zadanie3 {
	public static void main(String[] args) {
		String napis1 = "ala";
		String napis2 = "ala";
		// string jest jedynym obiektem ktorego mozna stworzyc BEZ pomocy
		// operatora new

		// string-poll/cache-poll/string-cache
		System.out.println(napis1 == napis2);

		String napis3 = "ala ma kota";
		String napis4 = napis3.substring(0, 3);

		System.out.println(napis1 == napis4);

		System.out.println(napis1 == napis4.intern());

		// immutable

		// dzieki temu ze obiekt jest niezmienny to Ty gwarantujesz ze HASHCODE
		// nigdy sie nie zmieni
		String napis5 = napis1.replaceAll("a", "X");
		System.out.println(napis1);
		System.out.println(napis5);
	}

	static final class Osoba {
		private final String imie;
		private final int wiek;

		public Osoba(String imie, int wiek) {
			this.imie = imie;
			this.wiek = wiek;
		}

		public String getImie() {
			return imie;
		}

		public int getWiek() {
			return wiek;
		}

		// opcjonalne
		public Osoba setWiek(int wiek) {
			return new Osoba(this.imie, wiek);
		}

	}
}
