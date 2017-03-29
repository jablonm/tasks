import java.util.HashSet;
import java.util.Set;

public class Zadanie2 {

	public static void main(String[] args) {
		//hahsert?
		//Stworz klase Osoba (imie, wiek)
		
		//w mainie stworz Hashseta do ktorego dodasz 3 osoby.
		
		Set<Osoba> osoby = new HashSet<>();
		
		Osoba os1 = new Osoba("Andrzej", 25);
		Osoba os2 = new Osoba("Marke", 35);
		Osoba os3 = new Osoba("Anna", 32);
		Osoba os4 = new Osoba("Andrzej", 25);
		
		osoby.add(os1);
		osoby.add(os2);
		osoby.add(os3);
		osoby.add(os4);
		
		System.out.println(os1.hashCode());
		System.out.println(os4.hashCode());
		
		System.out.println(os1.equals(os4));
		
		System.out.println(osoby.size());
		
		osoby.forEach(System.out::println);
		
		System.out.println(osoby.contains(os1));//true
		System.out.println(osoby.contains(os4));//true
		System.out.println(osoby.contains(new Osoba("Andrzej", 25)));//true
		
		os1.setImie("FRANEK");
		
		osoby.forEach(System.out::println);
		System.out.println(osoby.contains(os1));//false
		System.out.println(osoby.contains(new Osoba("FRANEK", 25)));//false
		System.out.println(osoby.contains(new Osoba("Andrzej", 25)));//false
		
		//nie mozemy usunac 25 letniego Franka (metoda remove)
		//osoby.remove(o)
		
		osoby.add(os1);
		System.out.println(osoby.size());
		
		osoby.forEach(System.out::println);
		
		//Czym jest hashSet?
		//HashSet -> HashMapa ktorej kluczem jest hashcode obiektu (Integer) a wartoscia Instancja Obiektu <OBIEKT>
		//hashcode os1 = 10
		//osoby.add(os1); // mapa: [10 -> os1]
		//os1.setIIME("XXX"); -> 20
		//osoby.contains(os1) -> czy w mapie jest hashcode 20? NIE
		//osoby.contains(new Osoba("XXX, 25") -> 20 NIE
		//osoby.contains(new Osoba("Andrzej", 25) -> 10 -> TAK, hashcode sie zgadza ALE POTEM set uzywa metody EQUALS aby porownac te dwa obiekty
		//sorry mamy 25 letniego XXX a nie 25 letniego Andrzeja -> false
		
		//aby poprawnie korzystac z kolekcji hashujacych nalezy zapewnic NIEZMIENNOSC obiketow przez caly ich cykl zycia (immutable)
		
		
	}
	
	static class Osoba {
		private String imie;
		private int wiek;
		
		public Osoba(String imie, int wiek) {
			super();
			this.imie = imie;
			this.wiek = wiek;
		}
		
		public String getImie() {
			return imie;
		}
		public void setImie(String imie) {
			this.imie = imie;
		}
		public int getWiek() {
			return wiek;
		}
		public void setWiek(int wiek) {
			this.wiek = wiek;
		}
		
		//co robi domyslnie hashcode?
		//domyslnie hashcode jest z klasy Object
		//i DOMYSLNIE to on zwraca w postaci inta numer komorki pamieci w ktorej znajduje sie obiekt
		
		
		//equals: co domyslnie robi?
		//equals domyslnie sprawdza REFERENCJE o1==o2
		
		

		@Override
		public String toString() {
			return "Osoba [imie=" + imie + ", wiek=" + wiek + "]";
		}

		//oblicza na podstawie pol klasy unikalny* numer hash dla danego obiektu
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((imie == null) ? 0 : imie.hashCode());
			result = prime * result + wiek;
			return result;
		}
		
		//ssprawdza po wszystkich polach czy obiekt jest identyczny z porownywanym
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Osoba other = (Osoba) obj;
			if (imie == null) {
				if (other.imie != null)
					return false;
			} else if (!imie.equals(other.imie))
				return false;
			if (wiek != other.wiek)
				return false;
			return true;
		}
		
		
		
	}
}
