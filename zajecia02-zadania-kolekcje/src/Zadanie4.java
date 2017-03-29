import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zadanie4 {

	public static void main(String[] args) {
		// Stworz klasie Immutable Osoba (imie, wiek, lista adresow email
		// (stringow))
		List<String> emails = new ArrayList<>(Arrays.asList("em1", "em2"));

		Osoba o1 = new Osoba("Jan", 20, emails);

		System.out.println(o1);

		emails.add("em3");

		System.out.println(o1);
	}

	static final class Osoba {
		private final String imie;
		private final int wiek;
		private final List<String> emaile;

		public Osoba(String imie, int wiek, List<String> emaile) {
			this.imie = imie;
			this.wiek = wiek;

			if (emaile != null) {
				this.emaile = new ArrayList<>(emaile);
			} else {
				this.emaile = null;
			}
		}

		public String getImie() {
			return imie;
		}

		public int getWiek() {
			return wiek;
		}

		public List<String> getEmaile() {
			if (emaile == null) {
				return null;
			}
			return new ArrayList<>(emaile);
		}

		@Override
		public String toString() {
			return "Osoba [imie=" + imie + ", wiek=" + wiek + ", emaile=" + emaile + "]";
		}

	}

}
