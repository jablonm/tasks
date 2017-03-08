package tasks01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task2Inheritance {
	public static void main(String[] args) {
		/*
		 * Stworz klase Osoba (imie, nazwiso, wiek) Klase student ktora
		 * dziedziczy osobe i dodatkowo posiada: nrIndexu i grupę Pracownik
		 * (stanowisko, pensja)
		 * 
		 * W mainie stworz liste osob (kilku studentow, kilku pracownikow)
		 * znajdz najstarsza osobe na liscie.
		 * 
		 */

		ArrayList<Osoba> listaOsob = new ArrayList<>();

		listaOsob.add(new Osoba("Jan", "Kowalski", 30));
		listaOsob.add(new Pracownik("Anna", "Nowak", 25, "programista", 8000));
		listaOsob.add(new Pracownik("Anna2", "Nowak2", 15, "programista", 9000));
		listaOsob.add(new Pracownik("Anna3", "Nowak3", 25, "tester", 7700));
		listaOsob.add(new Student("Andrzej", "Grabowski", 40, "A", "Nr7838"));

		Osoba tmpOsoba = listaOsob.get(0);
		for (Osoba osoba : listaOsob) {
			if (tmpOsoba.getWiek() < osoba.getWiek()) {
				tmpOsoba = osoba;
			}
		}

		// znajdz najstarsego pracownika
		// Osoba najstarszyPracownik = null;
		// for (Osoba osoba : listaOsob) {
		// if (osoba instanceof Pracownik) {
		// najstarszyPracownik = osoba;
		// }
		// }
		// for (Osoba osoba : listaOsob) {
		// if (osoba instanceof Pracownik) {
		// if (najstarszyPracownik.getWiek() < osoba.getWiek()) {
		// najstarszyPracownik = osoba;
		// }
		// }
		// }
		// System.out.println("Najstarszy pracownik to: " +
		// najstarszyPracownik.getImie() + " " +
		// najstarszyPracownik.getNazwisko());
		//
		// posorotowal liste osob po wieku (ASC)
		Collections.sort(listaOsob, new Comparator<Osoba>() {
			@Override
			public int compare(Osoba o1, Osoba o2) {
				return o1.getWiek() - o2.getWiek();
			}
		});
		// functional interface -> interfejs z jedna metoda
		// dziek temu mozemy uzyc lambdy zamiast pisac anonimowe impelementacje
		// klas
		Collections.sort(listaOsob, (o1, o2) -> o1.getWiek() - o2.getWiek());
		System.out.println("sorted by age:");
		// listaOsob.forEach(osoba -> System.out.println(osoba));

		// wywolanie funkcji jako argumentu JESLI interfejs posiada metode z
		// JEDNYM argumentem
		listaOsob.forEach(System.out::println);

		// listaOsob.forEach(new Consumer<Osoba>() {
		// @Override
		// public void accept(Osoba osoba) {
		// System.out.println(osoba);
		// }
		// });

		Osoba theOldest = listaOsob.stream().max((o1, o2) -> o1.getWiek() - o2.getWiek()).get();
		System.out.println("the oldest: " + theOldest);

		// Optional?
		Pracownik theOldestEmployee = listaOsob.stream().filter(Task2Inheritance::isPracownik)// o
																								// ->
																								// o
																								// instanceof
																								// Pracownik;
				.map(Task2Inheritance::cast)// o -> Pracownik.class.cast(o)
				.max((o1, o2) -> o1.getWiek() - o2.getWiek()).orElseThrow(PracownikNotFoundException::new);

		System.out.println("theOldestEmployee= " + theOldestEmployee);

		// znajdz najlepiej zarabiajacego pracownika, jesli brakuje pracownikow
		// na liscie rzuc PracownikNotFoundException
		// Policz ilu jest pracownikow na liscie
		// oblicz srednia pensje pracowonikow
		// oblicz srednia pensje programistow

		Pracownik maxSalary = listaOsob.stream()//
				.filter(o -> o instanceof Pracownik)//
				.map(o -> Pracownik.class.cast(o))//
				.max((o1, o2) -> o1.getPensja() - o2.getPensja())//
				.orElseThrow(PracownikNotFoundException::new);
		System.out.println("maxSalary: "+maxSalary);
		
//		int liczbaPracownikow = 0;
//		for (Osoba osoba : listaOsob) {
//			if (osoba instanceof Pracownik) {
//				liczbaPracownikow++;
//			}
//		}

		long liczbaPracownikow = listaOsob.stream().filter(Task2Inheritance::isPracownik).count();
		System.out.println(liczbaPracownikow);
		
//		double sredniaPensjaPracownikow = 0.0;
//		int liczbaPracownikow2 = 0;
//		for (Osoba osoba : listaOsob) {
//			if (osoba instanceof Pracownik) {
//				sredniaPensjaPracownikow += ((Pracownik) osoba).getPensja();
//				liczbaPracownikow++;
//			}
//		}
//		System.out.println("średnia pensja pracowników: "+ sredniaPensjaPracownikow/liczbaPracownikow);
		
		double sredniaPensjaPracownikow = listaOsob.stream().filter(Task2Inheritance::isPracownik)//
				.map(Task2Inheritance::cast).collect(Collectors.averagingDouble(Pracownik::getPensja));
		
		System.out.println(sredniaPensjaPracownikow);
		
		double sredniaPensjaProgramistow = listaOsob.stream().filter(Task2Inheritance::isPracownik)//
				.map(Task2Inheritance::cast)//
				.filter(o -> o.getStanowisko().equals("programista"))//
				.collect(Collectors.averagingDouble(Pracownik::getPensja));
		
		System.out.println(sredniaPensjaProgramistow);
		
		double suma = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;
		System.out.println((int)suma);
		
		
	}

	public static Pracownik cast(Osoba o) {
		return Pracownik.class.cast(o);
	}

	public static boolean isPracownik(Osoba o) {
		return o instanceof Pracownik;
	}

	static class PracownikNotFoundException extends RuntimeException {

	}

	static class Osoba {
		private String imie;
		private String nazwisko;
		private int wiek;

		public Osoba(String imie, String nazwisko, int wiek) {
			this.imie = imie;
			this.nazwisko = nazwisko;
			this.wiek = wiek;
		}

		public String getImie() {
			return imie;
		}

		public void setImie(String imie) {
			this.imie = imie;
		}

		public String getNazwisko() {
			return nazwisko;
		}

		public void setNazwisko(String nazwisko) {
			this.nazwisko = nazwisko;
		}

		public int getWiek() {
			return wiek;
		}

		public void setWiek(int wiek) {
			this.wiek = wiek;
		}

		@Override
		public String toString() {
			return "Osoba [imie=" + imie + ", nazwisko=" + nazwisko + ", wiek=" + wiek + "]";
		}

	}

	static class Student extends Osoba {
		private String grupa;
		private String nrIndexu;

		public Student(String imie, String nazwisko, int wiek, String grupa, String nrIndexu) {
			super(imie, nazwisko, wiek);
			this.grupa = grupa;
			this.nrIndexu = nrIndexu;
		}

		public String getGrupa() {
			return grupa;
		}

		public void setGrupa(String grupa) {
			this.grupa = grupa;
		}

		public String getNrIndexu() {
			return nrIndexu;
		}

		public void setNrIndexu(String nrIndexu) {
			this.nrIndexu = nrIndexu;
		}

	}

	static class Pracownik extends Osoba {
		private String stanowisko;
		private int pensja;

		public Pracownik(String imie, String nazwisko, int wiek, String stanowisko, int pensja) {
			super(imie, nazwisko, wiek);
			this.stanowisko = stanowisko;
			this.pensja = pensja;
		}

		public String getStanowisko() {
			return stanowisko;
		}

		public void setStanowisko(String stanowisko) {
			this.stanowisko = stanowisko;
		}

		public int getPensja() {
			return pensja;
		}

		public void setPensja(int pensja) {
			this.pensja = pensja;
		}

	}

}
